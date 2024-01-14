module com.mycompany.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.espol.tictactoe to javafx.fxml;
    exports com.espol.tictactoe;
    opens com.espol.tictactoe.controller to javafx.fxml;
    exports com.espol.tictactoe.controller;
    opens com.espol.tictactoe.model to javafx.fxml;
    exports com.espol.tictactoe.model;
    exports com.espol.tictactoe.logic;
    opens com.espol.tictactoe.logic to javafx.fxml;
}
