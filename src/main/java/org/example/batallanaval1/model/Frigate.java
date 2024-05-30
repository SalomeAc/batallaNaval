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
                16,0,
                0,16,
                0,32,
                32,32,
                32,16
        );
        frigate.setFill(Color.rgb(0,128,128));
        frigate.setStroke(Color.rgb(0,79,79));
        frigate.setStrokeWidth(1);

        // Agrega un evento de click al fragata para detectar clics del usuario
        frigate.setOnMouseClicked(this::handleFrigateClick);
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

    // Método para manejar el evento de click el la fragata
    private void handleFrigateClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el fragata cuando se hace clic derecho
            rotateClockwise();
            System.out.println("Fragata rotada");
        }
    }
    // Método para rotar el fragata
    private void rotateClockwise() {
        Rotate rotate = new Rotate(90, frigate.getBoundsInLocal().getWidth() / 2, frigate.getBoundsInLocal().getHeight() / 2);
        frigate.getTransforms().add(rotate);
    }

}