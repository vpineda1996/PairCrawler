package me.vpineda.util;

import java.util.Scanner;

/**
 * Created by vpineda1996 on 2015-05-17.
 */
public class Terminal {
    private String courseName, courseNumber, courseSection, session, username, password;
    private String COURSENAME = "Course Name", COURSENUMBER = "Course Number", COURSESECTION = "Course Section",
            SESSION = "Session", USERNAME = "Username", PASSWORD = "Password";

    public Terminal(String courseName, String courseNumber, String courseSection, String session, String username, String password) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.courseSection = courseSection;
        this.session = session;
        this.username = username;
        this.password = password;
    }

    public enum Element{
        COURSENAME, COURSENUMBER, COURSESECTION, SESSION, USERNAME, PASSWORD
    }

    public String get(Terminal.Element e) {
        switch (e){
            case COURSENAME:
                if(courseName != null)
                    return courseName;
                else
                    return courseName = Terminal.getElementFromTerminal(COURSENAME);
            case COURSENUMBER:
                if(courseNumber != null)
                    return courseNumber;
                else
                    return courseNumber = Terminal.getElementFromTerminal(COURSENUMBER);
            case COURSESECTION:
                if(courseSection != null)
                    return courseSection;
                else
                    return courseSection = Terminal.getElementFromTerminal(COURSESECTION);
            case SESSION:
                if(session != null)
                    return session;
                else
                    return session = Terminal.getElementFromTerminal(SESSION);
            case USERNAME:
                if(username != null)
                    return username;
                else
                    return username = Terminal.getElementFromTerminal(USERNAME);
            case PASSWORD:
                if(password != null)
                    return password;
                else {
                    return password = Terminal.getElementFromTerminal(PASSWORD);
                }
            default:
                return null;
        }
    }

    public boolean isSet(Terminal.Element e){
        switch (e){
            case COURSENAME:
                return courseName != null;
            case COURSENUMBER:
                return courseNumber != null;
            case COURSESECTION:
                return courseSection != null;
            case SESSION:
                return session != null;
            case USERNAME:
                return username != null;
            case PASSWORD:
                return password != null;
            default:
                return false;
        }
    }

    public static String getElementFromTerminal(String question){
        System.out.print(question + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static Terminal parseArguments(String[] args) {
        String courseName = null, courseNumber = null, courseSection = null, session = null,
                username = null, password = null;
        int i = 1;
        for (String arg : args) {
            if (arg.equals("-c") || arg.equals("--subject")) {
                courseName = args[i];
            } else if (arg.equals("-n") || arg.equals("--course")) {
                courseNumber = args[i];
            } else if (arg.equals("-s") || arg.equals("--section")) {
                courseSection = args[i];
            } else if (arg.equals("-y") || arg.equals("--year")) {
                session = args[i];
            } else if(arg.equals("-u") || arg.equals("--username")){
                username = args[i];
            } else if(arg.equals("-p") || arg.equals("--password")){
                password = args[i];
            }
            i++;
        }
        return new Terminal(courseName,courseNumber,courseSection,session,username,password);
    }
}
