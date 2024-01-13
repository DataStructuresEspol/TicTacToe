module com.mycompany.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.espol.tictactoe to javafx.fxml;
    exports com.espol.tictactoe;
    opens com.espol.tictactoe.controller to javafx.fxml;
    exports com.espol.tictactoe.controller;
    opens com.espol.tictactoe.modelo to javafx.fxml;
    exports com.espol.tictactoe.modelo;
}
