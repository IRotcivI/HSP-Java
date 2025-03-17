module appli.meditrack {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires mysql.connector.j;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens appli.meditrack to javafx.fxml;
    exports appli.meditrack;
    opens model to javafx.base;
    opens Fxml.gestionDesStocks to javafx.fxml;
    exports Fxml.gestionDesStocks;
}