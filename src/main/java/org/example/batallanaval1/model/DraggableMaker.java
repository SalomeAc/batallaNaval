package org.example.batallanaval1.model;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class DraggableMaker {
    private double posMouseX = 0, posMouseY = 0;
    private int parentWidth = 682;  // Ancho del AnchorPane
    private int parentHeight = 408; // Alto del AnchorPane
    private List<Point2D> playerShipPositions = new ArrayList<>();
    private final double POSITION_X1 = 69;
    private final double POSITION_X2 = 101;
    private final double POSITION_X3 = 133;
    private final double POSITION_X4 = 165;
    private final double POSITION_X5 = 197;
    private final double POSITION_X6 = 229;
    private final double POSITION_X7 = 261;
    private final double POSITION_X8 = 293;
    private final double POSITION_X9 = 325;
    private final double POSITION_X10 = 357;
    private final double POSITION_Y1 = 85;
    private final double POSITION_Y2 = 117;
    private final double POSITION_Y3 = 149;
    private final double POSITION_Y4 = 181;
    private final double POSITION_Y5 = 213;
    private final double POSITION_Y6 = 245;
    private final double POSITION_Y7 = 277;
    private final double POSITION_Y8 = 309;
    private final double POSITION_Y9 = 341;
    private final double POSITION_Y10 = 373;
    private double closestX;
    private double closestY;
    private boolean gameStarted = false;

    /**
     * Makes the specified node draggable.
     *
     * @param node the node to make draggable
     */

    public void makeDraggable(Node node) {
        node.setOnMousePressed(mouseEvent -> {
            if (!gameStarted) {
                // Solamente permitir arrastrar si el juego no ha comenzado
                posMouseX = mouseEvent.getSceneX() - node.getLayoutX();
                posMouseY = mouseEvent.getSceneY() - node.getLayoutY();
            }
        });

        node.setOnMouseDragged(mouseEvent -> {
            if (!gameStarted) {
                // Calcular nuevas posiciones
                double newX = mouseEvent.getSceneX() - posMouseX;
                double newY = mouseEvent.getSceneY() - posMouseY;

                // Asegurarse de que el nodo no se salga del AnchorPane
                if (newX >= 0 && newX <= parentWidth - node.getBoundsInParent().getWidth()) {
                    node.setLayoutX(newX);
                }
                if (newY >= 0 && newY <= parentHeight - node.getBoundsInParent().getHeight()) {
                    node.setLayoutY(newY);
                }
            }
        });

        node.setOnMouseReleased(mouseEvent -> {
            if (!gameStarted) {
                // Restablecer el desplazamiento cuando se suelta el mouse
                posMouseX = 0;
                posMouseY = 0;
                // Ajustar la posición a la más cercana
                adjustToClosestPosition(node);
            }
        });
    }

    /**
     * Retrieves the X coordinate of the last mouse position.
     *
     * @return the X coordinate of the last mouse position
     */
    public double getPosMouseX() {
        return posMouseX;
    }

    /**
     * Retrieves the Y coordinate of the last mouse position.
     *
     * @return the Y coordinate of the last mouse position
     */

    public double getPosMouseY() {
        return posMouseY;
    }
    /**
     * Sets the X coordinate of the last mouse position.
     *
     * @param posMouseX the X coordinate of the last mouse position
     */


    public void setPosMouseX(double posMouseX) {
        this.posMouseX = posMouseX;
    }
    /**
     * Sets the Y coordinate of the last mouse position.
     *
     * @param posMouseY the Y coordinate of the last mouse position
     */

    public void setPosMouseY(double posMouseY) {
        this.posMouseY = posMouseY;
    }

    /**
     * Retrieves the closest X coordinate to the node's position.
     *
     * @return the closest X coordinate
     */

    public double getClosestX() {
        return closestX;
    }
    /**
     * Retrieves the closest Y coordinate to the node's position.
     *
     * @return the closest Y coordinate
     */

    public double getClosestY() {
        return closestY;
    }

    /**
     * Adjusts the node position to the closest grid position.
     *
     * @param node the node to adjust
     */

    public void adjustToClosestPosition(Node node) {
        if (!gameStarted) {
            // Solamente ajustar la posición si el juego no ha comenzado
            double currentY = node.getLayoutY();
            double[] positionsY = {
                    POSITION_Y1, POSITION_Y2, POSITION_Y3, POSITION_Y4, POSITION_Y5,
                    POSITION_Y6, POSITION_Y7, POSITION_Y8, POSITION_Y9, POSITION_Y10
            };

            double closestY = positionsY[0]; // Inicializa closestY con la primera posición
            double minDifferenceY = Math.abs(currentY - positionsY[0]); // Calcula la diferencia absoluta con la primera posición

            for (int i = 1; i < positionsY.length; i++) {
                double difference = Math.abs(currentY - positionsY[i]); // Calcula la diferencia absoluta con la posición actual del bucle
                if (difference < minDifferenceY) { // Si la diferencia es menor que la mínima registrada hasta ahora
                    closestY = positionsY[i]; // Actualiza closestY con la posición actual
                    minDifferenceY = difference; // Actualiza la mínima diferencia registrada
                }
            }

            double currentX = node.getLayoutX();
            double[] positionsX = {
                    POSITION_X1, POSITION_X2, POSITION_X3, POSITION_X4, POSITION_X5,
                    POSITION_X6, POSITION_X7, POSITION_X8, POSITION_X9, POSITION_X10
            };
            double closestX = positionsX[0];
            double minDifferenceX = Math.abs(currentX - positionsX[0]);

            for (int i = 1; i < positionsX.length; i++) {
                double differenceX = Math.abs(currentX - positionsX[i]);
                if (differenceX < minDifferenceX) {
                    closestX = positionsX[i];
                    minDifferenceX = differenceX;
                }
            }
            node.setLayoutY(closestY);
            node.setLayoutX(closestX);
            playerShipPositions.add(new Point2D(closestX, closestY));
        }
    }

    /**
     * Retrieves the positions of the player's ships.
     *
     * @return a list of Point2D representing the positions of the player's ships
     */

    public List<Point2D> getPlayerShipPositions() {
        return playerShipPositions;
    }

    // Getters and setters omitted for brevity

    /**
     * Marks the start of the game.
     */
    public void startGame() {
        gameStarted = true;
    }

    /**
     * Checks if the game has started.
     *
     * @return true if the game has started, false otherwise
     */


    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * Sets the game started status.
     *
     * @param gameStarted the game started status to set
     */
    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
}