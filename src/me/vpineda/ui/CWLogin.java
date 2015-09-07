package me.vpineda.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import me.vpineda.request.Request;
import me.vpineda.util.Strings;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vpineda1996 on 2015-07-08.
 */
public class CWLogin extends Application{

    public static String cookie;
    public static boolean validated;

    public Stage mainStage;

    /**
     * Call this method from the request thread
     * @return
     * @throws InterruptedException
     */
    public static String getValidatedCookie() throws InterruptedException {
        if(!Request.JAVAFXTHREADRUNNING){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new CWLogin().start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Application.launch(CWLogin.class,(String) null);
                }
            }).start();
        }
        while(!validated && cookie == null){
            Thread.sleep(1000);
        }
        return cookie;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the pref file where all of the window is drawn
        Parent root = FXMLLoader.load(getClass().getResource("fxml/WebView.fxml"));
        // Set window title
        primaryStage.setTitle("Login into CWL");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        mainStage = primaryStage;

        setupWebView((WebView) primaryStage.getScene().lookup("#webView"));
    }

    private boolean cookieValid() {
        try{
            String req = Request.getResponseFromServer((HttpsURLConnection) new URL(Strings.GRADESSEREVERURL).openConnection(),null,cookie);
            int indexOfStart = req.indexOf("<input type=\"hidden\" name=\"token\"");
            String ans = req.substring(indexOfStart + 41, req.indexOf("/>",indexOfStart) - 2);
            return (ans.length() == 32);
        }catch (Exception e){
            return false;
        }
    }

    public void setupWebView(WebView wb){
        final WebEngine we = wb.getEngine();
        we.load(Strings.MAIN_PAIR_PAGE);

        we.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if(newValue == Worker.State.SUCCEEDED && we.getLocation().contains(Strings.GRADESSEREVERURL)){
                    try {
                        Map cookie = CookieHandler.getDefault().get(new URI(Strings.GRADESSEREVERURL),
                                new HashMap<String, List<String>>());
                        CWLogin.cookie = ((List<String>)cookie.get("Cookie")).get(0).substring(11);
                        validated = cookieValid();
                        if(validated) mainStage.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }

                } // TODO: Else do something else
            }
        });
    }
}
