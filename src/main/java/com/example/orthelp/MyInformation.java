package com.example.orthelp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyInformation {

    @FXML
    private Label classLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailLabel;

    private int userId = Session.getUserId();
    private RequestSql requestSql = new RequestSql();

    public void initialize() {

        User user = requestSql.getUserInformation(userId);


        if (user != null) {
            classLabel.setText("Class: " + user.getNiveau());

            firstNameLabel.setText("First Name: " + user.getPrenom());
            lastNameLabel.setText("Last Name: " + user.getNom());


            emailLabel.setText("Email: " + user.getEmail());
        } else
        {
            classLabel.setText("Class: Information unavailable");
            firstNameLabel.setText("First Name: Information unavailable");
            lastNameLabel.setText("Last Name: Information unavailable");
            emailLabel.setText("Email: Information unavailable");

        }
    }
}
