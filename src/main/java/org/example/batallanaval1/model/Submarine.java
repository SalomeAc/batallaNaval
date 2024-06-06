package org.example.batallanaval1.model;


import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

/**
 * Represents a submarine in the game.
 */
public class Submarine {

    private int shipId = 3;
    private Polygon submarine;
    private double layoutX, layoutY;

    /**
     * Constructs a Submarine object and initializes its polygon shape.
     */
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
        submarine.setOnMouseClicked(this::handleSubmarineClick);
    }

    /**
     * Sets the ship type.
     *
     * @param shipType the type of ship to set
     */
    public void setShipType(String shipType){ shipType = "Submarine";}

    /**
     * Gets the polygon representing the submarine.
     *
     * @return the submarine polygon
     */
    public Polygon getSubmarine() {
        return submarine;
    }

    /**
     * Sets the submarine polygon.
     *
     * @param submarine the polygon to set
     */
    public void setSubmarine(Polygon submarine) {
        this.submarine = submarine;
    }

    /**
     * Gets the X coordinate of the submarine's layout.
     *
     * @return the X coordinate of the layout
     */

    public double getLayoutX() {
        return layoutX;
    }

    /**
     * Sets the X coordinate of the submarine's layout.
     *
     * @param layoutX the X coordinate to set
     */
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
        submarine.setLayoutX(layoutX);
    }

    /**
     * Gets the Y coordinate of the submarine's layout.
     *
     * @return the Y coordinate of the layout
     */
    public double getLayoutY() {
        return layoutY;
    }

    /**
     * Sets the Y coordinate of the submarine's layout.
     *
     * @param layoutY the Y coordinate to set
     */
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
        submarine.setLayoutY(layoutY);
    }

    /**
     * Handles the click event on the submarine.
     *
     * @param mouseEvent the mouse event
     */
    private void handleSubmarineClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            rotateClockwise();
            System.out.println("Submarino rotado ");
        }
    }

    /**
     * Rotates the submarine clockwise.
     */
    private void rotateClockwise() {
        Rotate rotate = new Rotate(90, submarine.getBoundsInLocal().getWidth() / 2, submarine.getBoundsInLocal().getHeight() / 2);
        submarine.getTransforms().add(rotate);
    }

}
