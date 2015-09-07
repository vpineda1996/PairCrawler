package me.vpineda.ui;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by vpineda1996 on 2015-09-06.
 */
public class CWLoginTest {

    @Before
    public void setUp(){
        System.setProperty("jsse.enableSNIExtension", "false");
    }

    @Test
    public void testValidateCookie() throws Exception {

        CWLogin.getValidatedCookie();

    }
}