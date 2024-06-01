package org.example.batallanaval1.model;


import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class Submarine {
    private Polygon submarine;
    private double layoutX, layoutY;

    public Submarine() {
        submarine = new Polygon(
                0, 32,
                16, 0,
                32, 32,
                32, 96,
                0, 96

        );
        submarine.setFill(Color.web("#8E7BCC"));
        submarine.setStrokeWidth(1);
        submarine.setStroke(Color.web("Black"));

        // Agrega un evento de click al submarino para detectar clics del usuario
        submarine.setOnMouseClicked(this::handleRotarClick);
    }
    public Polygon getSubmarine() {
        return submarine;
    }

    public void setSubmarine(Polygon submarine) {
        this.submarine = submarine;
    }

    public double getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        submarine.setLayoutX(layoutX);
    }

    public double getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        submarine.setLayoutY(layoutY);
    }
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            submarine.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("Submarino Rotado");
        }
    }
}
