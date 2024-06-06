package org.example.batallanaval1.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
/**
 * Represents a Destroyer ship in the naval battle game.
 */
public class Destroyer {
    private int shipId = 2;
    private Polygon destroyer;
    private double layoutX,layoutY;
    /**
     * Constructs a Destroyer object with default properties.
     */
    public Destroyer(){
        destroyer = new Polygon(
                0,32,
                16,0,
                32,32,
                32,64,
                0, 64

        );
        destroyer.setFill(Color.web("#E8D3B0"));
        destroyer.setStroke(Color.BLACK);
        destroyer.setStrokeWidth(1);

        // Agrega un evento de click al destructor para detectar clics del usuario
        destroyer.setOnMouseClicked(this::handleRotarClick);
    }


    /**
     * Retrieves the polygon representing the Destroyer.
     * @return The Polygon object representing the Destroyer.
     */
    public Polygon getDestroyer(){return destroyer;}

    /**
     * Sets the Polygon object representing the Destroyer.
     * @param destroyer The Polygon object representing the Destroyer.
     */
    public void setDestroyer(Polygon destroyer) {
        this.destroyer = destroyer;
    }

    /**
     * Retrieves the layout X coordinate of the Destroyer.
     * @return The layout X coordinate of the Destroyer.
     */
    public double getLayoutX(){return layoutX;}
    /**
     * Retrieves the layout Y coordinate of the Destroyer.
     * @return The layout Y coordinate of the Destroyer.
     */
    public double getLayoutY(){return layoutY;}
    /**
     * Sets the layout X coordinate of the Destroyer.
     * @param x The layout X coordinate.
     */
    public void setLayoutX(double x){this.layoutX = layoutX;
        destroyer.setLayoutX(x);}
    /**
     * Sets the layout Y coordinate of the Destroyer.
     * @param y The layout Y coordinate.
     */
    public void setLayoutY(double y){this.layoutY = layoutY;
        destroyer.setLayoutY(y);}

    /**
     * Handles the mouse click event on the Destroyer.
     * Rotates the destroyer 90 degrees clockwise upon right-click.
     * @param mouseEvent The mouse event triggered by the click.
     */
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el destroyer cuando se hace clic derecho
            destroyer.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("Destroyer Rotada");
        }
    }
}