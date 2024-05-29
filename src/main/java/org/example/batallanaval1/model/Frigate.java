package org.example.batallanaval1.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class Frigate {
    private Polygon frigate;

    private double layoutX;
    private double layoutY;

    public Frigate() {
        frigate = new Polygon(
                0,32,//A
                16,0,//B
                32,32
        );
        frigate.setFill(Color.rgb(0,128,128));
        frigate.setStroke(Color.rgb(0,79,79));
        frigate.setStrokeWidth(1);

        // Agrega un evento de click al fragata para detectar clics del usuario
        frigate.setOnMouseClicked(this::handleRotarClick);
    }
    public Polygon getFrigate() {
        return frigate;
    }
    public void setFrigate(Polygon frigate) {this.frigate = frigate;}

    public double getLayoutX() {return layoutX;}
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        frigate.setLayoutX(layoutX);
    }

    public double getLayoutY() {return layoutY;}
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        frigate.setLayoutY(layoutY);
    }
    // Método para manejar el evento de click en los portaaviones
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            frigate.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("Fritanga Rotada");
        }
    }
}

