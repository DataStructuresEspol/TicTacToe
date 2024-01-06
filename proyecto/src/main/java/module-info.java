module com.mycompany.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto to javafx.fxml;
    exports com.mycompany.proyecto;
    opens controller to javafx.fxml;
    exports controller;
    opens modelo to javafx.fxml;
    exports modelo;
}
