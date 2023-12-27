package com.example.orthelp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.YearMonth;

public class HomeView {

    @FXML
    private GridPane calendarGrid;

    public void initialize() {
        showCalendar(LocalDate.now());
    }

    private void showCalendar(LocalDate date) {
        YearMonth yearMonth = YearMonth.from(date);

        // Clear previous calendar cells
        calendarGrid.getChildren().clear();

        // Add labels for days of the week
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < 7; i++) {
            Label dayLabel = new Label(daysOfWeek[i]);
            dayLabel.setStyle("-fx-font-weight: bold;");
            calendarGrid.add(dayLabel, i, 0);
        }

        // Add labels for days of the month
        int dayOfMonth = 1;
        for (int row = 1; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 1 && col < yearMonth.atDay(1).getDayOfWeek().getValue() % 7) {
                    // Skip empty cells before the first day
                    continue;
                }

                if (dayOfMonth <= yearMonth.lengthOfMonth()) {
                    Label dayLabel = new Label(Integer.toString(dayOfMonth));
                    calendarGrid.add(dayLabel, col, row);
                    dayOfMonth++;
                }
            }
        }
    }
}
