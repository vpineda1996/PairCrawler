package me.vpineda.request;

import com.sun.istack.internal.Nullable;
import javafx.application.Platform;
import javafx.stage.Stage;
import me.vpineda.database.Section;
import me.vpineda.database.SectionFactory;
import me.vpineda.exceptions.IllegalGradesReportException;
import me.vpineda.exceptions.IllegalRequestException;
import me.vpineda.exceptions.JSessionIDNotSetException;
import me.vpineda.exceptions.UnableToGetSectionsException;
import me.vpineda.ui.CWLogin;
import me.vpineda.ui.CaptchaWindow;
import me.vpineda.util.Strings;
import me.vpineda.util.Terminal;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vpineda1996 on 2015-05-17.
 */
public class Request {
    private final String GRADESPAGE = "gradesdist_request.action", ENGINESCRIPTPAGE = "dwr/engine.js";
    public String year = "2014W";
    private Terminal terminal;
    private static Request sigletonRequest;
    private static boolean initialized = false;

    public String jsessionid, scriptSessionCookie, token;
    public String mainSite, engineScript;

    public static Boolean JAVAFXTHREADRUNNING = false;

    public static class Type {
        private String session, subject, course;
        private Operation op;

        public Type(Operation op) {
            if(op == null) throw new RuntimeException("Must initialize with an specific operation");
            this.op = op;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public Operation getOp() {
            return op;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public void setOp(Operation op) {
            if(op == null) throw new RuntimeException("Must set with an specific operation");
            this.op = op;
        }
    }

    public enum Operation{
        SESSIONS,SUBJECTS,COURSES,SECTIONS;
    }

    public static Request getInstance(){
        if(sigletonRequest != null){
            return sigletonRequest;
        }else return sigletonRequest = new Request(Terminal.parseArguments(new String[]{}));
    }

    protected Request(Terminal terminal){
        this.terminal = terminal;
    }

    public void setTerminal(Terminal terminal){
        this.terminal = terminal;
    }

    public void initialize(){
        if(!initialized) {
            initializeServer();
            initialized = true;
        }
        if(terminal.isSet(Terminal.Element.SESSION)){
            year = terminal.get(Terminal.Element.SESSION);
        }
    }

    public void startCrawling() throws IOException {
        if(terminal.isSet(Terminal.Element.COURSENAME)){
            CourseSubject courseSubject = new CourseSubject(null,
                    terminal.get(Terminal.Element.COURSENAME));
            if(terminal.isSet(Terminal.Element.COURSENUMBER)){
                if(terminal.isSet(Terminal.Element.COURSESECTION)){
                    Set<String> sections = new HashSet<String>();
                    sections.add(terminal.get(Terminal.Element.COURSESECTION));
                    courseSubject.add(terminal.get(Terminal.Element.COURSENUMBER),
                            sections);
                }else courseSubject.add(terminal.get(Terminal.Element.COURSENUMBER),
                        new HashSet<String>());
            }
            crawl(courseSubject);
        }else {
            if(!CourseFactory.getInstance().hasBeenFilled())
                throw new RuntimeException("CouseFactory could not be initialized");
            for(CourseSubject courseSubject : CourseFactory.getInstance()){
                crawl(courseSubject);
            }
        }
    }

    public void crawl(CourseSubject courseSubject) throws IOException {
        if(courseSubject.getCourses().isEmpty()){
            fillInCourses(courseSubject.getCourses(), courseSubject.getAcronym());
        }
        for(String course : courseSubject.getCourses().keySet()){
            Set<String> sections = new HashSet<String>();
            if(courseSubject.hasSections(course)){
                sections = courseSubject.getSections(course);
            }else {
                try {
                    sections = fillInSections(courseSubject, course);
                } catch (UnableToGetSectionsException e) {
                    e.printStackTrace();
                }
            }
            for(String section : sections){
                try {
                    saveGradesForSection(year,courseSubject.getAcronym(), course, null, section);
                } catch (IllegalGradesReportException e) {
                    if(e.getMessage().contains("Please enter the displayed characters as displayed")){
                        saveGradesForSection(year,courseSubject.getAcronym(), course, null, section);
                    }
                }
            }
        }
    }

    /**
     *
     * @param year semester
     * @param subject the subject ex. CPSC
     * @param course course is the course number
     * @param detail detail is the detail of the course
     * @param section desired section
     * @throws IOException
     * @throws IllegalGradesReportException
     */
    public void saveGradesForSection(String year, String subject, String course, String detail, String section)
            throws IOException {
        if(year == null || subject == null || course ==  null || section == null)
            throw new IllegalRequestException();
        if(SectionFactory.getInstance().contains(new Section(year.substring(0,4),subject,course,section,null,detail,null))){
            return;
        }

        // Get captcha
        // Get the data from server
        URL url = new URL(Strings.GRADESSEREVERURL + Strings.RUNREPORT);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("POST");

        getNewToken(true);

        String captcha = getCaptchaResponse();
        String data = "struts.token.name=token&token=" + token +
                "&faculty=" +
                "&dept=" +
                "&reporttype=SECTION" +
                "&stud_no=" +
                "&campus=UBC" +
                "&yearsession="+ year +
                "&term=+&subject="+ subject +
                "&course="+ course +
                "&detail=" + ((detail != null) ? detail : "+")  +
                "&section=" + section +
                "&facultylist=" +
                "&deptlist=" +
                "&email=" +
                "&format=HTML" +
                "&captcha=" + captcha; //Terminal.getElementFromTerminal("Captcha"),"UTF-8");
        if(captcha.equals("CANCEL")){
            return;
        }
        String res = getResponseFromServer(connection, data);
        SectionFactory.getInstance().parseSectionFromHTTPRequest(res);
    }

    public String getCaptchaResponse() throws IOException {

        URL url = new URL(Strings.GRADESSEREVERURL + "images/captcha.jpg");
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestProperty("Cookie", Strings.JSESSIONCOOKIENAME + "=" + jsessionid);
        CaptchaWindow.setImage(connection.getInputStream());

        // Once we've set the image we run the Captcha window

        if(!JAVAFXTHREADRUNNING) {
            JAVAFXTHREADRUNNING = true;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    CaptchaWindow.launch(CaptchaWindow.class, (String) null);
                }
            });
            thread.setDaemon(true);
            thread.start();
        }else {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new CaptchaWindow().start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // Wait for the user to click OK for the captcha
        while (CaptchaWindow.getCaptchaResponse() == null){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Get the string the user wrote and set the captcha response to null
        String response = CaptchaWindow.getCaptchaResponse();
        System.out.println(response);
        CaptchaWindow.setCaptchaResponse(null);

        return response;
    }

    public void fillInCourses(CourseSubject courseSubject) throws IOException {
        this.fillInCourses(courseSubject.getCourses(),courseSubject.getAcronym());
    }

    public void fillInCourses(Map<String,Set<String>> courses, String courseAcronym) throws IOException {
        Type req = new Type(Operation.COURSES);
        req.setSession(year);
        req.setSubject(courseAcronym);

        Set<String> parsedCourses = parseCourses(requestXHR(jsessionid,scriptSessionCookie,req));
        for(String s: parsedCourses){
            courses.put(s,new HashSet<String>());
        }

    }

    /**
     * Adds all of the sections to the CourseSubject object
     * @param courseSubject the courseSubject where all of the sections will be stored
     * @param course the course that we want to parse
     * @return the set of sections (if we want to use it)
     * @throws UnableToGetSectionsException
     */
    public Set<String> fillInSections(CourseSubject courseSubject, String course) throws UnableToGetSectionsException{
        try {
            Type request = new Type(Operation.SECTIONS);

            request.setSession(year);
            request.setSubject(courseSubject.getAcronym());
            request.setCourse(course);
            Set<String> parsedSections = parseSections(requestXHR(jsessionid, scriptSessionCookie, request));
            courseSubject.getSections(course).addAll(parsedSections);
            return parsedSections;
        }catch (Exception e){
            throw new UnableToGetSectionsException();
        }
    }

    public Set<String> parseCourses(String response) {
        String lines[] = response.split(";");
        Set<String> parsedCourses = new HashSet<String>(50);
        String key;
        for(String s : lines){
            switch (s.charAt(0)){
                case 's':
                    if(s.length() > 12) {
                        if (s.contains("value")) {
                            key = s.substring(s.indexOf("=") + 2, s.length() - 1);
                            parsedCourses.add(key);
                        }
                    }
                    break;
            }
        }
        return parsedCourses;
    }

    public Set<String> parseSections(String response) {
        String lines[] = response.split(";");
        Set<String> parsedSections = new HashSet<String>(50);
        String key;
        for(String s : lines){
            switch (s.charAt(0)){
                case 's':
                    if(s.length() > 12) {
                        if (s.contains("value")) {
                            key = s.substring(s.indexOf("=") + 2, s.length() - 1);
                            if(validSection(key))
                                parsedSections.add(key);
                        }
                    }
                    break;
            }
        }
        System.out.println(parsedSections);
        return parsedSections;
    }

    private boolean validSection(String key) {
        return key.matches("^[0-9]{3}$");
    }

    private void initializeServer() {
        try {
            setupJsessionIdCookie();
            setupScriptTokenIdCookies();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupScriptTokenIdCookies() throws IOException {
        getNewToken(true);
        getNewScriptToken(true);
        if(scriptSessionCookie == null || scriptSessionCookie.length() <=0 || token == null || token.length() <= 0) System.exit(-2);
    }

    /**
     * Gets the script token, you must call this before filling in the factory
     * @throws IOException
     */
    public String getNewScriptToken(boolean refresh) throws IOException {
        if(refresh) {
            URL url = new URL(Strings.GRADESSEREVERURL + ENGINESCRIPTPAGE);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            engineScript = getResponseFromServer(connection, null);
        }
        try {
            int indexOfStart = engineScript.indexOf("dwr.engine._origScriptSessionId");
            scriptSessionCookie = engineScript.substring(indexOfStart + 35, engineScript.indexOf("\n", indexOfStart) - 2);

            System.out.println("New script token:\t" + scriptSessionCookie);
            return scriptSessionCookie;
        }catch (StringIndexOutOfBoundsException e){
            setupJsessionIdCookie();
            return getNewScriptToken(true);
        }
    }

    /**
     * Gets the token from the website so we can request new statistics
     * @param refresh if we want to load again the website
     * @return
     * @throws IOException
     */
    public String getNewToken(boolean refresh) throws IOException {
        if(refresh || mainSite == null) {
            URL url = new URL(Strings.GRADESSEREVERURL + GRADESPAGE);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            mainSite = getResponseFromServer(connection, null);
        }
        try {
            int indexOfStart = mainSite.indexOf("<input type=\"hidden\" name=\"token\"");
            token = mainSite.substring(indexOfStart + 41, mainSite.indexOf("/>",indexOfStart) - 2);
            System.out.println("New token:\t" + token);
            return token;
        }catch (StringIndexOutOfBoundsException e){
            setupJsessionIdCookie();
            return getNewToken(true);
        }

    }

    public String getRequestSession() {
        return year;
    }

    private void setupJsessionIdCookie() {
        try {
            jsessionid = CWLogin.getValidatedCookie();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(jsessionid.length() <= 0) System.exit(-1);
    }

    public static String requestXHR(String jsessionid, String scriptSession, Type request) throws IOException {
        URL webprod;
        switch (request.getOp()){
            case SESSIONS:
                webprod = new URL(Strings.GRADESSEREVERURL + Strings.SESSIONURL);
                break;
            case SUBJECTS:
                webprod = new URL(Strings.GRADESSEREVERURL + Strings.SUBJECTURL);
                break;
            case COURSES:
                webprod = new URL(Strings.GRADESSEREVERURL + Strings.COURSEURL);
                break;
            case SECTIONS:
                webprod = new URL(Strings.GRADESSEREVERURL + Strings.SECTIONURL);
                break;
            default:
                return null;
        }
        HttpsURLConnection connection = (HttpsURLConnection) webprod.openConnection();

        connection.setRequestMethod("POST");

        String req = null;
        switch (request.getOp()) {
            case SESSIONS:
                req = "callCount=1\n" +
                        "page=/reports/gradesdist_request.action\n" +
                        "httpSessionId=" + jsessionid + "\n" +
                        "scriptSessionId=" + scriptSession + "\n" +
                        "c0-scriptName=sisservice\n" +
                        "c0-methodName=getYearsessions\n" +
                        "c0-id=0\n" +
                        "c0-param0=string:UBC\n" +
                        "batchId=0\n";
                break;
            case SUBJECTS:
                req = "callCount=1\n" +
                        "page=/reports/gradesdist_request.action\n" +
                        "httpSessionId=" + jsessionid + "\n" +
                        "scriptSessionId=" + scriptSession + "\n" +
                        "c0-scriptName=sisservice\n" +
                        "c0-methodName=getSubjects\n" +
                        "c0-id=0\n" +
                        "c0-param0=string:UBC\n" +
                        "c0-param1=string:" + request.getSession() + "\n" +
                        "c0-param2=string:\n" +
                        "c0-param3=null:null\n" +
                        "c0-param4=null:null\n" +
                        "batchId=2\n";
                break;
            case COURSES:
                req = "callCount=1\n" +
                        "page=/reports/gradesdist_request.action\n" +
                        "httpSessionId=" + jsessionid + "\n" +
                        "scriptSessionId=" + scriptSession + "\n" +
                        "c0-scriptName=sisservice\n" +
                        "c0-methodName=getCourses\n" +
                        "c0-id=0\n" +
                        "c0-param0=string:UBC\n" +
                        "c0-param1=string:" + request.getSession() + "\n" +
                        "c0-param2=null:null\n" +
                        "c0-param3=null:null\n" +
                        "c0-param4=null:null\n" +
                        "c0-param5=string:" + request.getSubject() + "\n" +
                        "batchId=6\n";
                break;
            case SECTIONS:
                req = "callCount=1\n" +
                        "page=/reports/gradesdist_request.action\n" +
                        "httpSessionId=" + jsessionid + "\n" +
                        "scriptSessionId=" + scriptSession + "\n" +
                        "c0-scriptName=sisservice\n" +
                        "c0-methodName=getSections\n" +
                        "c0-id=0\n" +
                        "c0-param0=string:UBC\n" +
                        "c0-param1=string:" + request.getSession() + "\n" +
                        "c0-param2=string:" + request.getSubject() + "\n" +
                        "c0-param3=string:" + request.getCourse() + "\n" +
                        "c0-param4=string:%20\n" +
                        "batchId=8";
                break;
        }
        return getResponseFromServer(connection, req,jsessionid);
    }

    public String getResponseFromServer(HttpsURLConnection connection,@Nullable String formData) throws IOException {
        return getResponseFromServer(connection,formData,jsessionid);
    }

    public static String getResponseFromServer(HttpsURLConnection connection,@Nullable String formData, String jsessionid)
            throws IOException {

        if(formData != null) {//Encode data
            String type = "application/x-www-form-urlencoded";
            System.out.println(formData);
            connection.setRequestProperty("Content-Type", type);
            connection.setRequestProperty("Content-Length", String.valueOf(formData.length()));
        }

        connection.setRequestProperty("Cookie", Strings.JSESSIONCOOKIENAME + "=" + jsessionid);
        connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream (
                connection.getOutputStream());

        if(formData != null)
            wr.write(formData.getBytes());
        wr.close();

        //Get Response
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\n');
        }
        rd.close();
        return response.toString();
    }

    public void fillCourseFactory() throws IOException, JSessionIDNotSetException {
        if(jsessionid == null)
            throw new JSessionIDNotSetException();
        CourseFactory.getInstance().fillInFactory(year,jsessionid,scriptSessionCookie);
    }

}
