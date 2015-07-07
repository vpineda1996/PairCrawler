package me.vpineda.database;

import me.vpineda.exceptions.IllegalGradesReportException;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vpineda1996 on 2015-05-20.
 */
public class SectionFactory implements Serializable{
    /**
     * Singleton pattern
     */
    private static SectionFactory ourInstance = new SectionFactory();
    public static SectionFactory createFromFile(File file) throws IOException, ClassNotFoundException {
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if(!file.isFile())
            return null;
        FileInputStream fileInputStream =  new FileInputStream(file);
        ObjectInputStream obj_in =
                new ObjectInputStream(fileInputStream);
        Object object = obj_in.readObject();
        obj_in.close();
        if(object instanceof SectionFactory){
            return ourInstance = (SectionFactory) object;
        }
        else return null;
    }
    public void saveToFile(File file) throws IOException {
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(SectionFactory.getInstance());
        objectOutputStream.close();
    }
    public static SectionFactory getInstance() {
        return ourInstance;
    }
    private SectionFactory() {
    }

    private Set<Section> sections = new HashSet<Section>(50);

    public void add(Section s){
        sections.add(s);
    }

    public void remove(Section s){
        sections.remove(s);
    }

    public boolean contains(Section s){
        return sections.contains(s);
    }

    public Set<Section> getCourseSections(String session, String subjectAcronym, String courseNumber){
        Set<Section> sectionsReturn = new HashSet<Section>();
        for(Section s2 : sections){
            if(s2.getSession().equals(session)
                    && s2.getSubject().equals(subjectAcronym)
                    && s2.getCourse().equals(courseNumber))
                sectionsReturn.add(s2);
        }
        return sectionsReturn;
    }

    public Section parseSectionFromHTTPRequest(String httpResponse) throws IllegalGradesReportException {
        String session , subject, course, detail, section, professor;
        // Parse professor
        int cursor = -1;
        if(httpResponse.contains("<td>Instructor</td>")){
            cursor = httpResponse.indexOf("<td>Instructor</td>");
            professor = httpResponse.substring(cursor = cursor + 39 ,
                    cursor = httpResponse.indexOf("</td>",cursor - 8));

            session = httpResponse.substring(cursor = httpResponse.indexOf("colspan=\"6\"", cursor) + 12,
                    cursor = httpResponse.indexOf("</td",cursor));

            subject = httpResponse.substring(cursor = httpResponse.indexOf("colspan=\"6\"", cursor) + 12,
                    cursor = httpResponse.indexOf("</td",cursor));

            course = httpResponse.substring(cursor = httpResponse.indexOf("colspan=\"6\"", cursor) + 12,
                    cursor = httpResponse.indexOf("</td",cursor));

            detail = httpResponse.substring(cursor = httpResponse.indexOf("colspan=\"6\"", cursor) + 12,
                    cursor = httpResponse.indexOf("</td",cursor));

            section = httpResponse.substring(cursor = httpResponse.indexOf("colspan=\"6\"", cursor) + 12,
                    cursor = httpResponse.indexOf("</td",cursor));

            Grades grades = parseGrades(httpResponse,cursor);

            Section s = new Section(session,subject,course,section,professor,detail,grades);
            add(s);
            return s;
        }else throw new IllegalGradesReportException(httpResponse);
    }

    private Grades parseGrades(String httpResponse, int cursor) {
        String tmp;
        Grades grades = new Grades();
        tmp = httpResponse.substring(cursor = httpResponse.indexOf("colspan=\"7\"", cursor) + 267,
                cursor = httpResponse.indexOf("</td",cursor));
        grades.setAverage(Float.parseFloat(tmp));

        tmp = httpResponse.substring(cursor = cursor + 13,
                cursor = httpResponse.indexOf("</td",cursor));
        grades.setStandardDeviation(Float.parseFloat(tmp));

        tmp = httpResponse.substring(cursor = cursor + 13,
                cursor = httpResponse.indexOf("</td",cursor));
        grades.setHigh(Integer.parseInt(tmp));

        tmp = httpResponse.substring(cursor = cursor + 13,
                cursor = httpResponse.indexOf("</td",cursor));
        grades.setLow(Integer.parseInt(tmp));

        tmp = httpResponse.substring(cursor = cursor + 13,
                cursor = httpResponse.indexOf("</td",cursor));
        grades.setPass(Integer.parseInt(tmp));

        tmp = httpResponse.substring(cursor = cursor + 13,
                cursor = httpResponse.indexOf("</td",cursor));
        grades.setFail(Integer.parseInt(tmp));

        tmp = httpResponse.substring(cursor = cursor + 13,
                cursor = httpResponse.indexOf("</td",cursor));
        grades.setWithdrew(Integer.parseInt(tmp));

        int grd[] = new int[15];
        for (int i = 0, j = 0; i < 16; i++){
            tmp = httpResponse.substring(cursor = httpResponse.indexOf("colspan=\"6\"", cursor) + 12,
                    cursor = httpResponse.indexOf("</td",cursor));
            if(i == 5)
                continue;
            grd[j++] = Integer.parseInt(tmp);
        }
        grades.setAll(grd);
        return grades;
    }

    @Override
    public String toString() {
        return "SectionFactory{" +
                "sections=" + sections +
                '}';
    }
}
