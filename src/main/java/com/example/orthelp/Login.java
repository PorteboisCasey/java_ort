package com.example.orthelp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tools.ConnexionBDD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) {
        String email = usernameField.getText();
        String password = passwordField.getText();

        if (authenticate(email, password)) {
            showAlert("Connexion réussie.");
            try {
                loadHomeView();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Erreur lors du chargement de la vue principale.");
            }
        } else {
            showAlert("Identifiants incorrects. Veuillez réessayer.");
        }
    }

    private boolean authenticate(String email, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnexionBDD.getCnx();
            statement = connection.prepareStatement(
                    "SELECT id FROM user WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                Session.setUserId(userId); // Stockez l'ID utilisateur dans la classe de session
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Status");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void loadHomeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/orthelp/home.fxml"));
        Parent homeView = loader.load();

        Stage currentStage = (Stage) usernameField.getScene().getWindow();
        currentStage.setScene(new Scene(homeView));
        currentStage.setTitle("Accueil");
        currentStage.show();
    }
}
