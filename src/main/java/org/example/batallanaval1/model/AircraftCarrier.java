package org.example.batallanaval1.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class AircraftCarrier {
    private Polygon aircraftCarrier;
    private double layouty;
    private double layoutx;
    private int id;
    private DraggableMaker draggableMaker = new DraggableMaker();

    public AircraftCarrier() {


        aircraftCarrier = new Polygon(
                0, 32,//A
                16, 0,//B
                32, 32,//C
                32, 128,
                0, 128

        );

        //layoutX="472.0" layoutY="87.0"
        aircraftCarrier.setFill(Color.web("#64113F"));
        aircraftCarrier.setStroke(Color.BLACK);
        aircraftCarrier.setStrokeWidth(1);

        // Agrega un evento de click al PortaAvion para detectar clics del usuario
        aircraftCarrier.setOnMouseClicked(this::handleRotarClick);

    }


    public Polygon getAircraftCarrier() {
        return aircraftCarrier;
    }

    public void setAircraftCarrier(Polygon aircraftCarrier) {
        this.aircraftCarrier = aircraftCarrier;
    }

    public double getLayouty() {
        return layouty;
    }

    public void setLayouty(double layouty) {
        this.layouty = layouty;
        aircraftCarrier.setLayoutY(layouty);
    }

    public double getLayoutx() {
        return layoutx;
    }

    public void setLayoutx(double layoutx) {
        this.layoutx = layoutx;
        aircraftCarrier.setLayoutX(layoutx);
    }
    // Método para manejar el evento de click en los portaaviones
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            aircraftCarrier.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("PortaAviones rotado");
        }
    }
}

