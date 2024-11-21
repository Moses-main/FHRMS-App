module org.example.fhrms {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens org.example.fhrms to javafx.fxml;
    opens org.example.fhrms.model to javafx.fxml;
    opens org.example.fhrms.uicontroller.auth to javafx.fxml;
    opens org.example.fhrms.uicontroller.dashboard to javafx.fxml;
    exports org.example.fhrms;
    exports org.example.fhrms.uicontroller.auth;
    exports org.example.fhrms.model;
    exports org.example.fhrms.uicontroller.dashboard;
    exports org.example.fhrms.model2;
    opens org.example.fhrms.model2 to javafx.fxml;
}