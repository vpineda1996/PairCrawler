package me.vpineda.request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by vpineda1996 on 2015-05-17.
 */
public class CourseSubject {
    private String mainName, acronym;
    private Map<String,Set<String>> levelContainer= new HashMap<String,Set<String>>();

    public CourseSubject(String mainName, String acronym) {
        this.mainName = mainName;
        this.acronym = acronym;
    }

    public String getName() {
        return mainName;
    }

    public String getAcronym() {
        return acronym;
    }

    public void add(String course, Set<String> sections){
        levelContainer.put(course,sections);
    }

    public Set<String> getSections(String course) {
        return levelContainer.get(course);
    }

    public Map<String,Set<String>> getCourses(){
        return levelContainer;
    }

    public boolean hasCourses(){
        return levelContainer.keySet().size() > 0;
    }

    public boolean hasSections(String course){
        if(levelContainer.containsKey(course))
            if(levelContainer.get(course) != null)
                return levelContainer.get(course).size() > 0;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseSubject)) return false;

        CourseSubject courseSubject = (CourseSubject) o;

        return acronym.equals(courseSubject.acronym);

    }

    @Override
    public int hashCode() {
        return acronym.hashCode();
    }

    @Override
    public String toString() {
        return "CourseSubject{" +
                "mainName='" + mainName + '\'' +
                ", acronym='" + acronym + '\'' +
                ", levelContainer=" + levelContainer +
                '}';
    }

}
