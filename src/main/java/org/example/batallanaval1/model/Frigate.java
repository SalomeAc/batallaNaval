package org.example.batallanaval1.model;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Frigate {

    int spaceUsed = 1;

    private void polyline(Stage stage) {
        Polyline triangle1 = new Polyline();
        triangle1.getPoints().addAll(
                100.0, 350.0,  // Punto superior derecho
                0.0, 350.0,    // Punto superior izquierdo
                50.0, 400.0,   // Punto inferior medio
                100.0, 350.0);
        triangle1.setFill(Color.INDIANRED);
        triangle1.setStroke(Color.RED);

        HBox root = new HBox(triangle1);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Polylines");
        stage.show();

    }
}
