package org.example.batallanaval1.model;

import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Destroyer {
    private Polygon destroyer;
    private double layoutX,layoutY;

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
    public Polygon getDestroyer(){return destroyer;}

    public void setDestroyer(Polygon destroyer) {
        this.destroyer = destroyer;
    }

    public double getLayoutX(){return layoutX;}
    public double getLayoutY(){return layoutY;}

    public void setLayoutX(double x){this.layoutX = layoutX;
        destroyer.setLayoutX(x);}
    public void setLayoutY(double y){this.layoutY = layoutY;
        destroyer.setLayoutY(y);}

    private void handleRotarClick(javafx.scene.input.MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) { // botón derecho
            // Rotar el submarino cuando se hace clic derecho
            destroyer.getTransforms().add(new javafx.scene.transform.Rotate(90, 16, 48));
            System.out.println("Fritanga Rotada");
        }
    }
}