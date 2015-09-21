package me.vpineda;

import javafx.application.Application;
import me.vpineda.request.Request;
import me.vpineda.ui.MainUI;

public class Main {

    public static void main(String[] args) {
        // Some arguments so SSL can work
        System.setProperty("jsse.enableSNIExtension", "false");
        // Done, do your thing
        Request.JAVAFXTHREADRUNNING = true;
        Application.launch(MainUI.class);
    }
}
