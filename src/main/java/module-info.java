module com.erictoader.ordersdatabasemanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires java.desktop;
    requires itextpdf;
    requires mysql.connector.java;

    opens com.erictoader.ordersdatabasemanagement to javafx.fxml;
    exports com.erictoader.ordersdatabasemanagement;
    opens com.erictoader.ordersdatabasemanagement.Model to javafx.fxml;
    exports com.erictoader.ordersdatabasemanagement.Model;
}