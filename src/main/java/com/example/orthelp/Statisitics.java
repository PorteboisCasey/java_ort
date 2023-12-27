package com.example.orthelp;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import java.util.Map;

public class Statisitics {

    @FXML
    private LineChart<String, Number> lineChart1;
    @FXML
    private LineChart<String, Number> lineChart2;
    @FXML
    private LineChart<String, Number> lineChart3;

    private int currentChartIndex = 0;
    private LineChart<String, Number>[] charts;

    private RequestSql requestSql = new RequestSql();

    public void initialize() {
        charts = new LineChart[] { lineChart1, lineChart2, lineChart3 };
        populateDemandesParMatiereChart();
        populateDemandesParUtilisateurChart();
        showChart(0); // Afficher le premier graphique par défaut
    }

    private void populateDemandesParMatiereChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Demandes Par Matière");

        Map<String, Integer> data = requestSql.getDemandesParMatiere();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        lineChart1.getData().add(series);
    }

    private void populateDemandesParUtilisateurChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Demandes Par Utilisateur");

        Map<String, Integer> data = requestSql.getDemandesParUtilisateur();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        lineChart2.getData().add(series);
    }

    private void showChart(int index) {
        for (int i = 0; i < charts.length; i++) {
            if (charts[i] != null) {
                charts[i].setVisible(i == index);
            }
        }
        currentChartIndex = index;
    }

    @FXML
    private void handlePrevious() {
        int newIndex = currentChartIndex - 1;
        if (newIndex >= 0) {
            showChart(newIndex);
        }
    }

    @FXML
    private void handleNext() {
        int newIndex = currentChartIndex + 1;
        if (newIndex < charts.length && charts[newIndex] != null) {
            showChart(newIndex);
        }
    }
}
