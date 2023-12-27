package com.example.orthelp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button home;

    @FXML
    private Button myRequestButton;

    @FXML
    private Button makeArequestButton;

    @FXML
    private Button myInformatonButton;

    @FXML
    private Button mySkill;

    @FXML
    private Button statisiticsButton;


    @FXML
    private AnchorPane dashbordViewAnchorePane;
    private static AnchorPane anchorPane;


    public HelloController() {
    }

    public void onActionMyrequest(MouseEvent mouseEvent) throws IOException {
        // Method for handling the "My Request" action
        anchorPane = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(FxUtill.MYREQUEST)));
        dashbordViewAnchorePane.getChildren().setAll(anchorPane);

        home.setStyle("-fx-background-color: #000000;");
        myRequestButton.setStyle("-fx-background-color: #0496c7;");
        makeArequestButton.setStyle("-fx-background-color: #000000;");
        myInformatonButton.setStyle("-fx-background-color: #000000;");
        mySkill.setStyle("-fx-background-color: #000000;");
        statisiticsButton.setStyle("-fx-background-color: #000000;");
    }

    public void onActionMakeArequest(MouseEvent mouseEvent) throws IOException {
        anchorPane = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(FxUtill.MAKEAREQUEST)));
        dashbordViewAnchorePane.getChildren().setAll(anchorPane);

        home.setStyle("-fx-background-color: #000000;");
        myRequestButton.setStyle("-fx-background-color: #000000;");
        makeArequestButton.setStyle("-fx-background-color: #0496c7;");
        myInformatonButton.setStyle("-fx-background-color: #000000;");
        mySkill.setStyle("-fx-background-color: #000000;");
        statisiticsButton.setStyle("-fx-background-color: #000000;");
    }


    public void onActionMyInformation(MouseEvent mouseEvent) throws IOException {
        // Method for handling the "My Information" action
        anchorPane = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(FxUtill.MYINFORMATION)));
        dashbordViewAnchorePane.getChildren().setAll(anchorPane);

        home.setStyle("-fx-background-color: #000000;");
        myRequestButton.setStyle("-fx-background-color: #000000;");
        makeArequestButton.setStyle("-fx-background-color: #000000;");
        myInformatonButton.setStyle("-fx-background-color: #0496c7;");
        mySkill.setStyle("-fx-background-color: #000000;");
        statisiticsButton.setStyle("-fx-background-color: #000000;");
    }

    public void onActionMySkill(MouseEvent mouseEvent) throws IOException {
        // Method for handling the "My Skill" action
        anchorPane = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(FxUtill.MYSKILLS)));
        dashbordViewAnchorePane.getChildren().setAll(anchorPane);
        home.setStyle("-fx-background-color: #000000;");
        myRequestButton.setStyle("-fx-background-color: #000000;");
        makeArequestButton.setStyle("-fx-background-color: #000000;");
        myInformatonButton.setStyle("-fx-background-color: #000000;");
        mySkill.setStyle("-fx-background-color: #0496c7;");
        statisiticsButton.setStyle("-fx-background-color: #000000;");
    }

    public void onActionStatisTics(MouseEvent mouseEvent) throws IOException {
        // Method for handling the "Statistics" action
        anchorPane = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(FxUtill.STATISITICS)));
        dashbordViewAnchorePane.getChildren().setAll(anchorPane);

        home.setStyle("-fx-background-color: #000000;");
        myRequestButton.setStyle("-fx-background-color: #000000;");
        makeArequestButton.setStyle("-fx-background-color: #000000;");
        myInformatonButton.setStyle("-fx-background-color: #000000;");
        mySkill.setStyle("-fx-background-color: #000000;");
        statisiticsButton.setStyle("-fx-background-color: #0496c7;");
    }

    public void onActionHome(MouseEvent mouseEvent) throws IOException {
        anchorPane = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(FxUtill.HOMEVIEW)));
        dashbordViewAnchorePane.getChildren().setAll(anchorPane);


        home.setStyle("-fx-background-color: #0496c7;");
        myRequestButton.setStyle("-fx-background-color: #000000;");
        makeArequestButton.setStyle("-fx-background-color: #000000;");
        myInformatonButton.setStyle("-fx-background-color: #000000;");
        mySkill.setStyle("-fx-background-color: #000000;");
        statisiticsButton.setStyle("-fx-background-color: #000000;");
    }
}
