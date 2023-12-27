package com.example.orthelp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FxUtill {

    public static final String HOME = "home.fxml";
    public static final String MYREQUEST = "my_request.fxml";
    public static final String MAKEAREQUEST = "make_a_request.fxml";
    public static final String MYINFORMATION = "my_information.fxml";
    public static final String MYSKILLS = "my_skills.fxml";
    public static final String STATISITICS = "statisitics.fxml";

    public static final String HOMEVIEW = "home_view.fxml";

    public static final String LOGIN = "login.fxml";

    // load fxml view in the stage
    public static void loadAnchorView(Class<?> aClass, String fxSource, AnchorPane rootPane, Object... data) {
        try {
            // load view in anchor pane area and control separately
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxSource));
            AnchorPane pane = loader.load();
            // transfer data to the controller
            if (data.length > 0) {
                DataTraveler controller = loader.getController();
                controller.data(data);
            }
            rootPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // load fxml view in the stage
    public static void loadView(Class<?> aClass, ActionEvent event, String fxSource, String title, Object... data) {
        try {
            // load fxml
            FXMLLoader loader = new FXMLLoader(App.class.getResource(fxSource));
            Parent layout = loader.load();

            // transfer data to the controller
            if (data.length > 0) {
                DataTraveler controller = loader.getController();
                controller.data(data);
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(layout);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
