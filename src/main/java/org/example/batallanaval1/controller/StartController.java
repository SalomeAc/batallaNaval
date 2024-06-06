package org.example.batallanaval1.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.batallanaval1.model.*;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Controller class for the game start screen.
 */
public class StartController extends Stage {
    @FXML
    private Pane basicPane;
    @FXML
    private Button btnStart;
    @FXML
    private Pane gameBoard;
    @FXML
    private Pane enemyBoard;

    private Ship shipsPositions= new Ship();


    private DraggableMaker draggableMaker = new DraggableMaker();
    private AircraftCarrier portaAvion, enemyPortaAvion;
    private Destroyer destructores1, destructores2, enemyDestructores1, enemyDestructores2;
    private Submarine submarino1, submarino2, enemySubmarino1, enemySubmarino2;
    private Frigate fragata1, fragata2, fragata3, fragata4, enemyFragata1, enemyFragata2, enemyFragata3, enemyFragata4;

    private List<Pane> panes = new ArrayList<>();
    private Set<Pane> visitedPanes = new HashSet<>();
    private boolean playerTurn = true;

    private FileWriter attackPositionsWriter;

    private Image bombImage;
    private Image bombReal;

    private List<Point2D> playerShipPositions = new ArrayList<>();


    /**
     * Initializes the controller.
     */
    public void initialize() {
        initializeFigures();
        createGrid(gameBoard);
        createGrid(enemyBoard);


        // X IMAGE
        bombImage = new Image(getClass().getResource("/org/example/batallanaval1/Images/borrar.png").toExternalForm());
        bombReal = new Image(getClass().getResource("/org/example/batallanaval1/Images/bomb.png").toExternalForm());

        // Initially hide the enemyBoard
        enemyBoard.setVisible(false);

    }

    /**
     * Receives the positions of the player's ships.
     *
     * @param playerShipPositions positions of the player's ships
     */

    public void receivePlayerShipPositions(List<Point2D> playerShipPositions) {
        // Guarda las posiciones de los barcos del jugador en una lista
        this.playerShipPositions = playerShipPositions;
    }

    /**
     * Initializes the figures on the game board.
     */
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

        try {
        basicPane.getChildren().addAll(portaAvion.getAircraftCarrier
                (), fragata1.getFrigate(), fragata2.getFrigate(), fragata3.getFrigate(), fragata4.getFrigate(),
                submarino1.getSubmarine(), submarino2.getSubmarine(), destructores1.getDestroyer(), destructores2.getDestroyer());

            draggableMaker.makeDraggable(portaAvion.getAircraftCarrier());
            draggableMaker.makeDraggable(fragata1.getFrigate());
            draggableMaker.makeDraggable(fragata2.getFrigate());
            draggableMaker.makeDraggable(fragata3.getFrigate());
            draggableMaker.makeDraggable(fragata4.getFrigate());
            draggableMaker.makeDraggable(submarino1.getSubmarine());
            draggableMaker.makeDraggable(submarino2.getSubmarine());
            draggableMaker.makeDraggable(destructores1.getDestroyer());
            draggableMaker.makeDraggable(destructores2.getDestroyer());

        }
        catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cuidado");
            alert.setContentText("Hubo un error al cargar los barcos");
            alert.showAndWait();
        }
    }

    /**
     * Initializes the figures on the enemy board.
     */

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

        enemyBoard.getChildren().addAll(enemyPortaAvion.getAircraftCarrier(), enemyFragata1.getFrigate(), enemyFragata2.getFrigate(),
                enemyFragata3.getFrigate(), enemyFragata4.getFrigate(), enemySubmarino1.getSubmarine(), enemySubmarino2.getSubmarine(), enemyDestructores1.getDestroyer(), enemyDestructores2.getDestroyer());
    }



    /**
     * Creates a grid on the specified board pane.
     *
     * @param board the board pane to create the grid on
     */
    private void createGrid(Pane board) {


        int gridSize = 11; // Grid size
        int paneSize = 32; // Pane size

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                String id = (String.valueOf((char) ('A' + j - 1))).concat(String.valueOf(i));
                StackPane pane = new StackPane();
                pane.setId(id);
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
                    if(i==0){
                        Label label = new Label(String.valueOf((char) ('A' + j - 1)));
                        label.setStyle("-fx-text-fill: #000000;" +
                                "-fx-alignment: center;" +
                                "-fx-font-weight: bold;");
                        pane.setStyle("-fx-background-color: rgb(157,162,189);" +
                                "-fx-border-color: rgb(5,25,75);" +
                                "-fx-stroke-type: inside;" +
                                "-fx-alignment: center");
                        pane.getChildren().add(label);
                    }else if(j==0){
                        Label label = new Label(String.valueOf(i));
                        label.setStyle("-fx-text-fill: #000000;" +
                                "-fx-alignment: center;" +
                                "-fx-font-weight: bold;");
                        pane.setStyle("-fx-background-color: rgb(157,162,189);" +
                                "-fx-border-color: rgb(5,19,75);" +
                                "-fx-stroke-type: inside;" +
                                "-fx-alignment: center");
                        pane.getChildren().add(label);
                    }

                } else {
                    pane.setOnMouseClicked(event -> {
                        if (playerTurn) {
                            if (shipsPositions.getShipsPositions().contains(pane.getId())) {
                                System.out.println("Hay un barco en " + pane.getId());
                                // Mostrar imagen de bomba
                                ImageView bombView = new ImageView(new Image(getClass().getResource("/org/example/batallanaval1/Images/bomb.png").toExternalForm()));
                                bombView.setFitWidth(paneSize);
                                bombView.setFitHeight(paneSize);
                                pane.getChildren().add(bombView);
                            } else {
                                System.out.println("No hay un barco en "+ pane.getId());
                                // Mostrar imagen de X
                                ImageView xView = new ImageView(new Image(getClass().getResource("/org/example/batallanaval1/Images/borrar.png").toExternalForm()));
                                xView.setFitWidth(paneSize);
                                xView.setFitHeight(paneSize);
                                pane.getChildren().add(xView);
                            }
                            Pane clickedPane = (Pane) event.getSource();
                            if (isIndicatorPane(clickedPane)) {
                                return; // Ignorar los clics en los indicadores
                            }
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

    /**
     * Handles the machine's move during the game.
     */

    private void machineMove() {
        List<Pane> gameBoardPanes = new ArrayList<>();
        try {
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
                String cellId = randomPane.getId();

                // Verificar si la celda contiene un barco del jugador
                Point2D clickedPosition = new Point2D(randomPane.getLayoutX(), randomPane.getLayoutY());
                if (playerShipPositions.contains(clickedPosition)) {
                    // La máquina hizo clic en una celda que contiene un barco del jugador

                    ImageView bombView = new ImageView(bombReal);
                    bombView.setFitWidth(32);
                    bombView.setFitHeight(32);
                    randomPane.getChildren().add(bombView);
                } else {
                    // La celda está vacía, mostrar la imagen de la bomba
                    ImageView bombView = new ImageView(bombImage);
                    bombView.setFitWidth(32);
                    bombView.setFitHeight(32);
                    randomPane.getChildren().add(bombView);
                }

            System.out.println("Machine's click position: " + randomPane.getLayoutX() +
                    ", y: " + randomPane.getLayoutY() + ". ID: " + randomPane.getId());


                attackPositionsWriter = new FileWriter("attackPositions.txt");
                attackPositionsWriter.write(randomPane.getId() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Change turn back to player after machine makes its move
        playerTurn = true;
        if (allShipsHit()) {
            Platform.runLater(() -> showAlert("¡Has ganado!", "¡Felicidades, has destruido todos los barcos enemigos!"));
        }

    }

    /**
     * Checks if all enemy ships have been hit.
     *
     * @return true if all enemy ships have been hit, otherwise false
     */
    private boolean allShipsHit() {
        // Verificar si todas las posiciones de los barcos han sido golpeadas
        for (String shipPosition : shipsPositions.getShipsPositions()) {
            boolean hit = false;
            for (Node node : enemyBoard.getChildren()) {
                if (node instanceof Pane) {
                    Pane pane = (Pane) node;
                    if (pane.getId().equals(shipPosition)) {
                        // Verificar si el barco ha sido golpeado
                        if (!pane.getChildren().isEmpty()) {
                            hit = true;
                            break;
                        }
                    }
                }
            }
            if (!hit) {
                return false; // Al menos una posición de barco no ha sido golpeada
            }
        }
        return true; // Todas las posiciones de los barcos han sido golpeadas
    }

    /**
     * Checks if a pane is an indicator pane.
     *
     * @param pane the pane to check
     * @return true if the pane is an indicator pane, otherwise false
     */

    private boolean isIndicatorPane(Pane pane) {
        String id = pane.getId();
        return id.charAt(0) == '0' || id.charAt(1) == '0' || // Excluir filas y columnas enumeradas
                pane.getStyle().contains("rgb(157,162,189)"); // Excluir las celdas con el color de fondo gris

    }
    private int extractShipId(Pane pane) {
        String[] parts = pane.getId().split(",");
        if (parts.length == 2) {
            return Integer.parseInt(parts[0]); // O el índice que corresponda al ID del barco
        } else {
            return -1; // Manejar el caso de error
        }
    }


    /**
     * Handles the action when the start game button is clicked.
     *
     * @param event the ActionEvent associated with the button click
     * @throws UnlocatedShipsException if the player's ships are not located on the game board
     */
    @FXML
    void onHandleButtonStartGame(ActionEvent event) throws UnlocatedShipsException {

        enemyBoard.setVisible(true);
        try {
            if (gameBoard.getChildren().isEmpty()) {
                throw new UnlocatedShipsException("Please locate your ships");
            }

        } catch (UnlocatedShipsException e) {
            showAlert("Error", e.getMessage());
        }
    }


    /**
     * Shows an alert with the specified title and content.
     *
     * @param title   the title of the alert
     * @param content the content of the alert
     */
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
