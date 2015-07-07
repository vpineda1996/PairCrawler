package me.vpineda;

import me.vpineda.request.test.RequestTest;
import me.vpineda.util.Terminal;

public class Main {

    public static void main(String[] args) {
        // Some arguments so SSL can work
        System.setProperty("jsse.enableSNIExtension", "false");
        // Done, do your thing
        new RequestTest(Terminal.parseArguments(args)).initialize();
    }
}
