module com.example.selfhelp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.orthelp to javafx.fxml;
    exports com.example.orthelp;
}