package me.vpineda.ui;

import com.apple.eawt.AppEvent;
import com.apple.eawt.AppReOpenedListener;
import com.apple.eawt.QuitHandler;
import com.apple.eawt.QuitResponse;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import me.vpineda.database.Section;
import me.vpineda.database.SectionFactory;
import me.vpineda.exceptions.JSessionIDNotSetException;
import me.vpineda.request.CourseFactory;
import me.vpineda.request.CourseSubject;
import me.vpineda.request.Request;
import me.vpineda.util.Strings;
import sun.awt.OSInfo;

import java.awt.*;
import java.awt.MenuItem;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created by vpineda1996 on 2015-05-26.
 */
public class MainUI extends Application{

    private static boolean WINDOWOPENED = false;

    /**
     * Only called once when the object or window is initialized for the first time
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();
        // If you are in MACOSX we'll adjust some system settings so the dock can work properly
        if(OSInfo.OSType.MACOSX.equals(OSInfo.getOSType())) {
            setupMacCustomPrefs();
        }
        // On anther thread we'll initialize the controller
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request.getInstance().initialize();
            }
        }).start();
        // Read all of the info from the database if there is one present
        SectionFactory.createFromFile(new File(Strings.SECTIONFACTORYPATH));
    }

    /**
     * Method called whenever the window is shown or the system wants to open a new window
     * @param primaryStage the stage where the window will be created
     * @throws Exception
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        if(MainUI.WINDOWOPENED){
            primaryStage.close();
        }else {
            // Load the pref file where all of the window is drawn
            Parent root = FXMLLoader.load(getClass().getResource("fxml/MainUi.fxml"));
            // Set window title
            primaryStage.setTitle("PairCrawler");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            // Set the window opened so we dont have dupes
            setWindowOpened();
            // Initialize the barChart
            try {
                HistogramScene.getInstance().setupChart((AnchorPane) primaryStage.getScene().lookup("#mainDisplayAnchorPane"));
            }catch (Exception e) {
                e.printStackTrace();
            }
            // This is a variable that we need to set so that any other window such as the Captcha window can know
            // the FX thread is running
            Request.JAVAFXTHREADRUNNING = true;
            // On a new thread setup all of the elements in the UI with their respective callbacks
            new Thread(new Runnable() {
                @Override
                public void run() {
                    setupRefreshAndSubjectListView(primaryStage);
                    setupOpenCloseWindow(primaryStage);
                    setupCourseListView(primaryStage);
                }
            }).start();
        }
    }

    /**
     * Called when the window is opened, use carefully
     * IT MAY CAUSE BUGS
     */
    public void setWindowOpened() {
        MainUI.WINDOWOPENED = true;
    }

    /**
     * Sets the callback for the close window action
     * @param primaryStage the stage that will be modified
     */
    private void setupOpenCloseWindow(Stage primaryStage) {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                // With this we tell the app that we are ready to open a new window if necessary
                MainUI.WINDOWOPENED = false;
            }
        });
    }

    private void setupRefreshAndSubjectListView(final Stage primaryStage) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ListView<String> listView = (ListView) primaryStage.getScene().lookup("#listViewMain");
                fillInListView(listView);
                listView.requestFocus();
                setupSubjectListViewListners(listView, primaryStage);
            }
        });
        Button refreshButton = (Button) primaryStage.getScene().lookup("#refreshButton");
        refreshButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Request.getInstance().fillCourseFactory();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            fillInListView((ListView) primaryStage.getScene().lookup("#listViewMain"));
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (final JSessionIDNotSetException e){
                    Alert alert = new Alert(Alert.AlertType.ERROR,
                            "Please fill in JSESSIONID",
                            ButtonType.OK,
                            ButtonType.CLOSE);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        System.out.println("Calling CWL for login");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    CWLogin.getValidatedCookie();
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }).start();
                    }
                }
            }
        });
    }

    private void setupSubjectListViewListners(ListView<String> listView, final Stage primaryStage) {
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null && CourseFactory.getInstance().containsSubject(newValue)) {
                    final CourseSubject cs = new CourseSubject(null,newValue.substring(0,4));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Request.getInstance().fillInCourses(cs);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        ListView<String> courseslistView =
                                                (ListView) primaryStage.getScene().lookup("#listViewCourses");
                                        List<String> coursesList = new LinkedList<String>();
                                        for(String course : cs.getCourses().keySet()){
                                            coursesList.add(course);
                                        }
                                        Collections.sort(coursesList, new Comparator<String>() {
                                            @Override
                                            public int compare(String o1, String o2) {
                                                int n1 = Integer.parseInt(o1);
                                                int n2 = Integer.parseInt(o2);
                                                return (n1 == n2) ? 0 : ((n2 > n1) ? -1 : 1);
                                            }
                                        });
                                        courseslistView.setItems(FXCollections.observableArrayList(coursesList));
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    private void setupCourseListView(Stage primaryStage) {
        ListView<String> courseListView = (ListView) primaryStage.getScene().lookup("#listViewCourses");
        final ListView<String> subjectListView = (ListView) primaryStage.getScene().lookup("#listViewMain");
        courseListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
                HistogramScene.getInstance().clear();
                if (newValue != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                CourseSubject courseSubject = new CourseSubject(null, subjectListView
                                        .getSelectionModel()
                                        .getSelectedItem().substring(0,4));
                                courseSubject.add(newValue.substring(0,3), new HashSet<String>());
                                Request.getInstance().crawl(courseSubject);
                                final Set<Section> sections =
                                        SectionFactory.getInstance().getCourseSections(Request
                                                .getInstance()
                                                .getRequestSession().substring(0,4),
                                                subjectListView.getSelectionModel()
                                                .getSelectedItem().substring(0,4),
                                                newValue.substring(0,3));
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        HistogramScene.getInstance().updateGraph(sections);
                                    }
                                    });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    public void fillInListView(ListView<String> listView) {
        List<String> list = new ArrayList<String>(220);
        if(!CourseFactory.getInstance().hasBeenFilled())
            list.add("Try refreshing again");
        for(CourseSubject courseSubject : CourseFactory.getInstance()){
            list.add(courseSubject.getName());
        }
        listView.setItems(FXCollections.observableArrayList(list));
    }

    private void setupMacCustomPrefs(){
        com.apple.eawt.Application app = com.apple.eawt.Application.getApplication();
        PopupMenu menu = new PopupMenu("default");
        menu.add(new MenuItem("Woot"));
        app.setDockMenu(menu);
        app.setQuitHandler(new QuitHandler() {
            @Override
            public void handleQuitRequestWith(AppEvent.QuitEvent quitEvent, QuitResponse quitResponse) {
                Platform.exit();
            }
        });
        app.addAppEventListener(new AppReOpenedListener() {
            @Override
            public void appReOpened(AppEvent.AppReOpenedEvent appReOpenedEvent) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            new MainUI().start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        try {
            SectionFactory.getInstance().saveToFile(new File(Strings.SECTIONFACTORYPATH));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }
}
