package com.example.orthelp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MySkills {

    @FXML
    private ListView<String> skillsListView;

    @FXML
    private ComboBox<String> matiereComboBox;

    @FXML
    private ComboBox<String> sousMatiereComboBox;

    @FXML
    private TextField skillsTextField;

    @FXML
    private Button addSkillButton;

    public void initialize() {
        ObservableList<String> matieres = FXCollections.observableArrayList(
                "Mathématiques",
                "Physique",
                "Informatique",
                "Français",
                "Histoire-Géographie",
                "CEJM"
        );
        matiereComboBox.setItems(matieres);

        ObservableList<String> sousMatieres = FXCollections.observableArrayList(
                "Algèbre",
                "Mécanique",
                "Programmation"
        );
        sousMatiereComboBox.setItems(sousMatieres);

        ObservableList<String> skills = FXCollections.observableArrayList(
                "Analyse",
                "Développement Web",
                "Réseaux"
        );
        skillsListView.setItems(skills);
    }

    @FXML
    private void onAddSkill() {
        String skill = skillsTextField.getText();
        if (skill != null && !skill.isEmpty() && !skillsListView.getItems().contains(skill)) {
            skillsListView.getItems().add(skill);
            skillsTextField.clear();
        }
    }

}
