package org.example.batallanaval1.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.batallanaval1.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StartController extends Stage {
    @FXML
    private Pane basicPane;
    @FXML
    private Button btnStart;
    @FXML
    private Pane gameBoard;
    @FXML
    private Pane enemyBoard;

    private DraggableMaker draggableMaker = new DraggableMaker();
    private AircraftCarrier portaAvion, enemyPortaAvion;
    private Destroyer destructores1, destructores2, enemyDestructores1, enemyDestructores2;
    private Submarine submarino1, submarino2, enemySubmarino1, enemySubmarino2;
    private Frigate fragata1, fragata2, fragata3, fragata4, enemyFragata1, enemyFragata2, enemyFragata3, enemyFragata4;

    private List<Pane> panes = new ArrayList<>();
    private Set<Pane> visitedPanes = new HashSet<>();
    private boolean playerTurn = true;

    private Image bombImage;

    public void initialize() {
        initializeFigures();
        createGrid(gameBoard);
        createGrid(enemyBoard);
        initializeEnemyFigures();

        // Load bomb image
        bombImage = new Image(getClass().getResource("/org/example/batallanaval1/images/bomb.png").toExternalForm());

        // Initially hide the enemyBoard
        enemyBoard.setVisible(false);
    }

    private void initializeFigures() {
        destructores1 = new Destroyer();
        destructores1.setLayoutX(570);
        destructores1.setLayoutY(250);

        destructores2 = new Destroyer();
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

        FiguresCreator base = new FiguresCreator();

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

        basicPane.getChildren().addAll(portaAvion.getPortaAviones(), fragata1.getFrigate(), fragata2.getFrigate(), fragata3.getFrigate(), fragata4.getFrigate(), submarino1.getSubmarine(), submarino2.getSubmarine(), destructores1.getDestroyer(), destructores2.getDestroyer());

        draggableMaker.makeDraggable(portaAvion.getPortaAviones());
        draggableMaker.makeDraggable(fragata1.getFrigate());
        draggableMaker.makeDraggable(fragata2.getFrigate());
        draggableMaker.makeDraggable(fragata3.getFrigate());
        draggableMaker.makeDraggable(fragata4.getFrigate());
        draggableMaker.makeDraggable(submarino1.getSubmarine());
        draggableMaker.makeDraggable(submarino2.getSubmarine());
        draggableMaker.makeDraggable(destructores1.getDestroyer());
        draggableMaker.makeDraggable(destructores2.getDestroyer());
    }

    private void initializeEnemyFigures() {
        enemyDestructores1 = new Destroyer();
        enemyDestructores1.setLayoutX(32 * 6);
        enemyDestructores1.setLayoutY(32 * 1);

        enemyDestructores2 = new Destroyer();
        enemyDestructores2.setLayoutX(32 * 8);
        enemyDestructores2.setLayoutY(32 * 3);

        enemyPortaAvion = new AircraftCarrier();
        enemyPortaAvion.setLayoutx(32 * 2);
        enemyPortaAvion.setLayouty(32 * 4);

        enemySubmarino1 = new Submarine();
        enemySubmarino1.setLayoutX(32 * 1);
        enemySubmarino1.setLayoutY(32 * 7);

        enemySubmarino2 = new Submarine();
        enemySubmarino2.setLayoutX(32 * 4);
        enemySubmarino2.setLayoutY(32 * 2);

        enemyFragata1 = new Frigate();
        enemyFragata1.setLayoutX(32 * 9);
        enemyFragata1.setLayoutY(32 * 8);
        enemyFragata2 = new Frigate();
        enemyFragata2.setLayoutX(32 * 9);
        enemyFragata2.setLayoutY(32 * 9);
        enemyFragata3 = new Frigate();
        enemyFragata3.setLayoutX(32 * 8);
        enemyFragata3.setLayoutY(32 * 7);
        enemyFragata4 = new Frigate();
        enemyFragata4.setLayoutX(32 * 7);
        enemyFragata4.setLayoutY(32 * 6);

        enemyBoard.getChildren().addAll(enemyPortaAvion.getPortaAviones(), enemyFragata1.getFrigate(), enemyFragata2.getFrigate(), enemyFragata3.getFrigate(), enemyFragata4.getFrigate(), enemySubmarino1.getSubmarine(), enemySubmarino2.getSubmarine(), enemyDestructores1.getDestroyer(), enemyDestructores2.getDestroyer());
    }

    private void createGrid(Pane board) {
        int gridSize = 11; // Grid size
        int paneSize = 32; // Pane size

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Pane pane = new Pane();
                pane.setId(String.valueOf(i).concat(String.valueOf(j)));
                pane.setPrefWidth(paneSize);
                pane.setPrefHeight(paneSize);
                pane.setStyle("-fx-background-color: rgb(199,216,249);" +
                        "-fx-border-color: rgba(0,0,0,0.7);" +
                        "-fx-stroke-type: inside;");

                double xPosition = j * paneSize + paneSize;
                double yPosition = i * paneSize + paneSize;

                pane.setLayoutX(xPosition);
                pane.setLayoutY(yPosition);

                board.getChildren().add(pane);
                panes.add(pane);

                if (i == 0 || j == 0) {
                    Label label = new Label("1");
                    label.setStyle("-fx-text-fill: #000000;" +
                            "-fx-alignment: center;" +
                            "-fx-font-weight: bold;");
                    pane.setStyle("-fx-background-color: rgb(157,162,189);" +
                            "-fx-border-color: rgb(5,19,75);" +
                            "-fx-stroke-type: inside;" +
                            "-fx-alignment: center");
                    pane.getChildren().add(label);
                } else {
                    pane.setOnMouseClicked(event -> {
                        if (playerTurn) {
                            Pane clickedPane = (Pane) event.getSource();
                            if (isIndicatorPane(clickedPane)) {
                                return; // Ignorar los clics en los indicadores
                            }
                            clickedPane.setStyle("-fx-background-color: rgb(255,0,0);" +
                                    "-fx-border-color: rgba(0,0,0,0.7);" +
                                    "-fx-stroke-type: inside;");
                            System.out.println("La posición en x es: " + clickedPane.getLayoutX() + "" +
                                    ", y es: " + clickedPane.getLayoutY() +
                                    ". El id es " + clickedPane.getId());

                            // Change turn to machine after player clicks
                            playerTurn = false;
                            // Wait 2 seconds before machine makes its move
                            Timeline delayTimeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> machineMove()));
                            delayTimeline.play();
                        }
                    });
                }
            }
        }
    }

    private void machineMove() {
        List<Pane> gameBoardPanes = new ArrayList<>();
        for (Node node : gameBoard.getChildren()) {
            if (node instanceof Pane) {
                gameBoardPanes.add((Pane) node);
            }
        }
        Random random = new Random();
        Pane randomPane;
        do {
            int randomIndex = random.nextInt(gameBoardPanes.size());
            randomPane = gameBoardPanes.get(randomIndex);
        } while (visitedPanes.contains(randomPane) || isIndicatorPane(randomPane));

        visitedPanes.add(randomPane);

        // Place bomb image on randomPane
        ImageView bombView = new ImageView(bombImage);
        bombView.setFitWidth(32);
        bombView.setFitHeight(32);
        randomPane.getChildren().add(bombView);

        System.out.println("Machine's click position: " + randomPane.getLayoutX() +
                ", y: " + randomPane.getLayoutY() + ". ID: " + randomPane.getId());

        // Change turn back to player after machine makes its move
        playerTurn = true;
    }

    private boolean isIndicatorPane(Pane pane) {
        String id = pane.getId();
        return id.charAt(0) == '0' || id.charAt(1) == '0';
    }

    @FXML
    void onHandleButtonStartGame(ActionEvent event) {
        enemyBoard.setVisible(true);
    }
}