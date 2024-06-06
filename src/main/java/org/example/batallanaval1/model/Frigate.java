package org.example.batallanaval1.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

/**
 * Represents a frigate ship in the game.
 */
public class Frigate {
    private Polygon frigate;

    private int shipId = 1;

    private double layoutX;
    private double layoutY;

    /**
     * Constructs a frigate ship with default properties.
     */
    public Frigate() {
        frigate = new Polygon(

                16,0,
                0,16,
                0,32,
                32,32,
                32,16

        );
        frigate.setFill(Color.rgb(0,128,128));
        frigate.setStroke(Color.web("Black"));
        frigate.setStrokeWidth(1);


        // Agrega un evento de click al fragata para detectar clics del usuario
        frigate.setOnMouseClicked(this::handleRotarClick);
    }

    /**
     * Gets the frigate polygon.
     *
     * @return the frigate polygon
     */
    public Polygon getFrigate() {
        return frigate;
    }

    /**
     * Sets the layout X coordinate of the frigate.
     *
     * @param layoutX the layout X coordinate to set
     */
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        frigate.setLayoutX(layoutX);
    }

    /**
     * Sets the layout Y coordinate of the frigate.
     *
     * @param layoutY the layout Y coordinate to set
     */

    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        frigate.setLayoutY(layoutY);
    }
    /**
     * Handles the mouse click event on the Frigate.
     * Rotates the destroyer 90 degrees clockwise upon right-click.
     * @param mouseEvent The mouse event triggered by the click.
     */

    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            frigate.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("Frigata Rotada");
        }
    }
}