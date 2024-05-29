package org.example.batallanaval1.controller;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import org.example.batallanaval1.model.*;
import org.example.batallanaval1.view.GameStage;
import org.example.batallanaval1.view.StartStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class generates the first stage designed to put
 * the ships on the board
 * @author Nathalia Ortiz
 */

public class StartController extends Stage {
    @FXML
    private Pane basicPane;

    @FXML
    private Button btnStart;

    @FXML
    private Pane gameBoard;

    @FXML
    private HBox hbxHead;

    @FXML
    private Label lblTitle;
    @FXML
    private GridPane gridPlayer1;

    public GridPane getGridPlayer1() {
        return gridPlayer1;
    }

    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
    private DraggableMaker draggableMaker = new DraggableMaker();
    private Submarine submarino1,submarino2;
    private Destroyer destructores1,destructores2;
    private AircraftCarrier portaAvion;
    private FiguresCreator base;
    private Frigate fragata1,fragata2,fragata3,fragata4;


    public void initialize(){
        destructores1=new Destroyer();
        destructores1.setLayoutX(570);
        destructores1.setLayoutY(250);

        destructores2=new Destroyer();
        destructores2.setLayoutX(525);
        destructores2.setLayoutY(250);

        portaAvion = new AircraftCarrier();
        portaAvion.setLayoutx(450);
        portaAvion.setLayouty(85);

        submarino1 = new Submarine();
        submarino1.setLayoutX(487);
        submarino1.setLayoutY(85);

        submarino2 = new Submarine();
        submarino2.setLayoutX(487);
        submarino2.setLayoutY(200);

        base = new FiguresCreator();

        fragata1 = new Frigate();
        fragata1.setLayoutX(525);
        fragata1.setLayoutY(85);
        fragata2 = new Frigate();
        fragata2.setLayoutX(560);
        fragata2.setLayoutY(85);
        fragata3 = new Frigate();
        fragata3.setLayoutX(594);
        fragata3.setLayoutY(85);
        fragata4 = new Frigate();
        fragata4.setLayoutX(628);
        fragata4.setLayoutY(85);

        int gridSize = 11; // Tamaño de la cuadrícula
        int paneSize = 352 / gridSize; // Tamaño de cada pane

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Pane pane = new Pane();
                pane.setId(String.valueOf(i).concat(String.valueOf(j)));
                pane.setPrefWidth(32);
                pane.setPrefHeight(32);
                pane.setStyle("-fx-background-color: rgb(177,194,255);" +
                        "-fx-border-color: rgba(0,0,0,0.7);" +
                        "-fx-stroke-type: inside;");

                double xPosition = j * paneSize;
                double yPosition = i * paneSize;

                pane.setLayoutX(xPosition);
                pane.setLayoutY(yPosition);

                gameBoard.getChildren().add(pane);
                if (i == 0 || j == 0) {
                    Label label = new Label("A");
                    label.setStyle("-fx-text-fill: yellow;" +
                            "-fx-alignment: center;" +
                            "-fx-font-weight: bold;");
                    pane.setStyle("-fx-background-color: rgb(4,19,114);" +
                            "-fx-border-color: rgb(5,19,75);" +
                            "-fx-stroke-type: inside;" +
                            "-fx-alignment: center");
                    pane.getChildren().add(label);
                } else {
                    pane.setOnMouseEntered(event -> {
                        pane.setStyle("-fx-background-color: rgb(173,173,173,0.66);" +
                                "-fx-border-color: rgba(0,0,0,0.7);" +
                                "-fx-stroke-type: inside;");
                    });

                    pane.setOnMouseExited(event -> {
                        pane.setStyle("-fx-background-color: rgb(177,194,255);" +
                                "-fx-border-color: rgba(0,0,0,0.7);" +
                                "-fx-stroke-type: inside;");
                    });

                    pane.setOnMouseClicked(event -> {
                        System.out.println("La posicion en x es: " + pane.getLayoutX() + "" +
                                ", y es: " + pane.getLayoutY() +
                                ". El id es " + pane.getId());
                    });
                }
            }
        }


        basicPane.getChildren().addAll(portaAvion.getPortaAviones(), fragata1.getFrigate(), fragata2.getFrigate(),fragata3.getFrigate(),fragata4.getFrigate(), submarino1.getSubmarino(),submarino2.getSubmarino(),destructores1.getDestructor(),destructores2.getDestructor());

        draggableMaker.makeDraggable(portaAvion.getPortaAviones());
        draggableMaker.makeDraggable(fragata1.getFrigate());
        draggableMaker.makeDraggable(fragata2.getFrigate());
        draggableMaker.makeDraggable(fragata3.getFrigate());
        draggableMaker.makeDraggable(fragata4.getFrigate());
        draggableMaker.makeDraggable(submarino1.getSubmarino());
        draggableMaker.makeDraggable(submarino2.getSubmarino());
        draggableMaker.makeDraggable(destructores1.getDestructor());
        draggableMaker.makeDraggable(destructores2.getDestructor());
    }

    @FXML
    void onHandleButtonStartGame(ActionEvent event) throws IOException {
        try {
            GameStage gameStage = GameStage.getInstance(gridPlayer1);
            gameStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pane getGameBoard() {
        return gameBoard;
    }
}