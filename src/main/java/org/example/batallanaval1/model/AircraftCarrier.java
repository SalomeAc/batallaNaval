package org.example.batallanaval1.model;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;

public class AircraftCarrier {
    private Polygon portaAviones;
    private double layouty;
    private double layoutx;
    private int id;
    private DraggableMaker draggableMaker = new DraggableMaker();

    public AircraftCarrier() {


        portaAviones = new Polygon(
                0, 32,//A
                16, 0,//B
                32, 32,//C
                16, 32,//D
                32, 64,//E
                16, 64,//F
                32, 96,//G
                16, 96,//H
                32, 128,//I
                0, 128,//J
                16, 96,//H
                0, 96,//K
                16, 64,//F
                0, 64,//L
                16, 32,//D
                0, 32//A
        );

        //layoutX="472.0" layoutY="87.0"
        portaAviones.setFill(Color.RED);
        portaAviones.setStroke(Color.BLACK);
        portaAviones.setStrokeWidth(1);

        // Agrega un evento de click al PortaAvion para detectar clics del usuario
        portaAviones.setOnMouseClicked(this::handleRotarClick);

    }


    public Polygon getPortaAviones() {
        return portaAviones;
    }

    public void setPortaAviones(Polygon portaAviones) {
        this.portaAviones = portaAviones;
    }

    public double getLayouty() {
        return layouty;
    }

    public void setLayouty(double layouty) {
        this.layouty = layouty;
        portaAviones.setLayoutY(layouty);
    }

    public double getLayoutx() {
        return layoutx;
    }

    public void setLayoutx(double layoutx) {
        this.layoutx = layoutx;
        portaAviones.setLayoutX(layoutx);
    }
    // Método para manejar el evento de click en los portaaviones
    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            portaAviones.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("PortaAviones rotado");
        }
    }
}


