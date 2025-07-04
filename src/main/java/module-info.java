module com.ads.projetoa3.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.ads.projetoa3.app to javafx.fxml;
    opens com.ads.projetoa3.app.models to javafx.base;
    exports com.ads.projetoa3.app;
    exports com.ads.projetoa3.app.enums;
    exports com.ads.projetoa3.app.controllers;
    opens com.ads.projetoa3.app.controllers to javafx.fxml;
}