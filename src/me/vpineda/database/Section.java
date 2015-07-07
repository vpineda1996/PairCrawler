package me.vpineda.database;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;

/**
 * Created by vpineda1996 on 2015-05-20.
 */
public class Section implements Serializable{
    private String session, subject, course, detail, section, professor;
    private Grades grades;

    public Section(@NotNull String session,@NotNull String subject,@NotNull String course,@NotNull String section, @NotNull String prof, String detail, Grades grades) {
        this.session = session;
        this.subject = subject;
        this.course = course;
        this.detail = detail;
        this.section = section;
        this.professor = prof;
        this.grades = grades;
    }

    public String getProfessor() {
        return professor;
    }

    public String getSession() {
        return session;
    }

    public String getSubject() {
        return subject;
    }

    public String getCourse() {
        return course;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSection() {
        return section;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;

        Section section1 = (Section) o;

        if (!session.equals(section1.session)) return false;
        if (!subject.equals(section1.subject)) return false;
        if (!course.equals(section1.course)) return false;
        return section.equals(section1.section);

    }

    @Override
    public int hashCode() {
        int result = session.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + course.hashCode();
        result = 31 * result + section.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Section{" +
                "session='" + session + '\'' +
                ", subject='" + subject + '\'' +
                ", course='" + course + '\'' +
                ", detail='" + detail + '\'' +
                ", section='" + section + '\'' +
                ", professor='" + professor + '\'' +
                ", grades=" + grades +
                '}';
    }
}
