package me.vpineda.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vpineda1996 on 2015-05-18.
 */
public class CourseFactory implements Iterable<CourseSubject>{

    private List<CourseSubject> coursesContainer = new ArrayList<CourseSubject>(220);

    /**«
     * Singleton pattern
     */
    private static CourseFactory ourInstance = new CourseFactory();
    public static CourseFactory getInstance() {
        return ourInstance;
    }

    private CourseFactory() {
    }

    public boolean fillInFactory(String semester, String jsessionid, String scriptSession) throws IOException {
        Request.Type request = new Request.Type(Request.Operation.SUBJECTS);
        request.setSession(semester);
        if(coursesContainer.size() >= 0){
            coursesContainer = new ArrayList<CourseSubject>(220);
        }

        return parseCourses(Request.requestXHR(jsessionid,scriptSession,request));
    }

    public boolean parseCourses(String queryResponse) {
        String lines[] = queryResponse.split(";");
        String key = "";
        String value = "";
        boolean i = false, j = false;
        for(String s : lines){
            switch (s.charAt(0)){
                case 's':
                    if(s.length() > 12) {
                        if (s.contains("value")) {
                            key = s.substring(s.indexOf("=") + 2, s.length() - 1);
                            i = true;
                        }
                    }
                    break;
                case '\n':
                    if(s.length() > 12) {
                        s = s.substring(1);
                        if (s.contains("label")) {
                            value = s.substring(s.indexOf("=") + 2, s.length() - 1);
                            j = true;
                        }
                    }
                    break;
            }
            if(i && j){
                coursesContainer.add(new CourseSubject(value,key));
                i = j = false;
            }
        }
        return true;
    }

    public boolean hasBeenFilled(){
        return !coursesContainer.isEmpty();
    }

    public CourseSubject getCourseSubject(String id) {
        for(CourseSubject c : coursesContainer){
            if(c.equals(new CourseSubject(null,id)))
                return c;
        }
        return null;
    }

    public Iterator<CourseSubject> getAllCourseSubjects(){
        return coursesContainer.iterator();
    }

    public boolean containsSubject(String courseAcronym){
        for(CourseSubject cs : coursesContainer){
            if(cs.getAcronym().equals(courseAcronym.substring(0,4))){
                return true;
            }
        }
        return false;
    }

    public Iterator<CourseSubject> iterator(){
        return coursesContainer.iterator();
    }
}
