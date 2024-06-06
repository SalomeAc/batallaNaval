package org.example.batallanaval1.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.Serial;

/**
 * Represents an Aircraft Carrier ship in the naval battle game.
 */


public class AircraftCarrier {
    private int shipId = 4;
    private Polygon aircraftCarrier;
    private double layouty;
    private double layoutx;
    private int id;
    private DraggableMaker draggableMaker = new DraggableMaker();
    /**
     * Constructs an AircraftCarrier object with default properties.
     */
    public AircraftCarrier() {

        aircraftCarrier = new Polygon(
                0, 32,//A
                16, 0,//B
                32, 32,//C
                32, 128,
                0, 128

        );

        aircraftCarrier.setFill(Color.web("#64113F"));
        aircraftCarrier.setStroke(Color.BLACK);
        aircraftCarrier.setStrokeWidth(1);

        // Agrega un evento de click al PortaAvion para detectar clics del usuario
        aircraftCarrier.setOnMouseClicked(this::handleRotarClick);

    }

    /**
     * Retrieves the polygon representing the Aircraft Carrier.
     * @return The Polygon object representing the Aircraft Carrier.
     */
    public Polygon getAircraftCarrier() {
        return aircraftCarrier;
    }

    /**
     * Sets the layout Y coordinate of the Aircraft Carrier.
     * @param layouty The layout Y coordinate.
     */

    public void setLayouty(double layouty) {
        this.layouty = layouty;
        aircraftCarrier.setLayoutY(layouty);
    }


    /**
     * Sets the layout X coordinate of the Aircraft Carrier.
     * @param layoutx The layout X coordinate.
     */

    public void setLayoutx(double layoutx) {
        this.layoutx = layoutx;
        aircraftCarrier.setLayoutX(layoutx);
    }
    /**
     * Handles the mouse click event on the Aircraft Carrier.
     * Rotates the aircraft carrier 90 degrees clockwise upon right-click.
     * @param mouseEvent The mouse event triggered by the click.
     */
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            aircraftCarrier.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("PortaAviones rotado");
        }
    }
}

