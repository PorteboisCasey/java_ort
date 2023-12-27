package com.example.orthelp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MakeARequest {

    @FXML
    private ComboBox<Matiere> subjectComboBox;
    @FXML
    private ComboBox<String> classComboBox;
    @FXML
    private ComboBox<String> MatiereComboBox;

    private final RequestSql requestSql = new RequestSql();

    @FXML
    public void initialize() {
        loadSubjects();
        loadClasses();
        loadSousMatieres();

    }

    private void loadSubjects() {
        ArrayList<Matiere> subjects = requestSql.GetAllMatieres();
        subjectComboBox.setItems(FXCollections.observableArrayList(subjects));
    }

    private void loadClasses() {
        ArrayList<String> classes = requestSql.GetAllSalles();
        classComboBox.setItems(FXCollections.observableArrayList(classes));
    }

    private void loadSousMatieres() {
        ArrayList<String> sousMatieres = requestSql.GetAllSousMatiere();
        MatiereComboBox.setItems(FXCollections.observableArrayList(sousMatieres));
    }

    @FXML
    private void onRequestButtonClick(ActionEvent event) {
        Matiere selectedMatiere = subjectComboBox.getValue();
        String selectedClass = classComboBox.getValue();
        String selectedSousMatiere = MatiereComboBox.getValue();

        int userId = Session.getUserId();
        int matiereId = selectedMatiere.getId();

        LocalDateTime dateFinDemande = LocalDateTime.now().plusWeeks(1);
        int status = 1;

        requestSql.addDemande(LocalDateTime.now(), dateFinDemande, selectedSousMatiere, userId, matiereId, status);

    }
}
