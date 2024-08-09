module main.books {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfoenix;
    requires java.sql;
    requires fontawesomefx;

    opens main to javafx.fxml;
    opens homepage to javafx.fxml;
    opens dialog to javafx.fxml;
    opens show to javafx.fxml;

    exports main;
    exports homepage;
    exports dialog;
    exports show;
}