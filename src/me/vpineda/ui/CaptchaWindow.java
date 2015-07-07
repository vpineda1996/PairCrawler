package me.vpineda.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vpineda1996 on 2015-05-24.
 */
public class CaptchaWindow extends Application {

    private static InputStream image;
    private static String captchaResponse;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/CaptchaDialog.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

        Button okButton = (Button) primaryStage.getScene().lookup("#okButton");
        Button cancelButton = (Button) primaryStage.getScene().lookup("#cancelButton");
        ImageView imageView = (ImageView) primaryStage.getScene().lookup("#captchaImageView");
        final TextField captchaInputArea = (TextField) primaryStage.getScene().lookup("#captchaInput");

        displayImage(imageView);

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                captchaResponse = captchaInputArea.getCharacters().toString();
                primaryStage.close();
            }
        });
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                captchaResponse = "CANCEL";
            }
        });
    }

    private void displayImage(ImageView imageView) {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (CaptchaWindow.image != null) {
                imageView.setImage(new Image(image));
                try {
                    image.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static InputStream getImage() {
        return image;
    }

    public static void setImage(InputStream image) {
        CaptchaWindow.image = image;
    }

    public static String getCaptchaResponse() {
        return captchaResponse;
    }

    public static void setCaptchaResponse(String captchaResponse) {
        CaptchaWindow.captchaResponse = captchaResponse;
    }

    @Override
    public void init() throws Exception {
        super.init();
        Platform.setImplicitExit(false);
    }
}
