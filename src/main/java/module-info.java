module com.example.sqltest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sqltest to javafx.fxml;
    exports com.example.sqltest;
}