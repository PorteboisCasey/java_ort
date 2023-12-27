package com.example.orthelp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.ArrayList;


public class MyRequest {

    @FXML
    private ListView<String> requestListView;

    public void initialize() {
        RequestSql requestSql = new RequestSql();

        int userId = Session.getUserId();
        ArrayList<String> requests = requestSql.getAllRequests(userId);

        ObservableList<String> observableRequests = FXCollections.observableArrayList(requests);
        requestListView.setItems(observableRequests);

        requestListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Requetes choisies: " + newValue);
        });
    }
}
