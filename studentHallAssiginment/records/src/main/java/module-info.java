module com.example.records {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.records to javafx.fxml;
    exports com.example.records;
}