package org.example.batallanaval1.model;
import javafx.scene.layout.Pane;


public class FiguresCreator {

    private Pane pane;
    private int id;

    /**
     * Constructs a FiguresCreator object.
     */
    public FiguresCreator() {

        this.id = id;
        pane = new Pane();
        pane.setPrefWidth(32);
        pane.setPrefHeight(32);
        pane.setStyle("-fx-background-color: rgb(255,255,255);" +
                "-fx-border-color: rgba(0,0,0,0.7);" +
                "-fx-stroke-type: inside;");
    }
}