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

    opens org.example.fhrms to javafx.fxml;
    opens org.example.fhrms.auth to javafx.fxml;
    exports org.example.fhrms;
    exports org.example.fhrms.auth;
}