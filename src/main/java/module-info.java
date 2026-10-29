module gui.gamedemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens gui.gamedemo to javafx.fxml;
    exports gui.gamedemo;
}