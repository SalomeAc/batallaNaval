package org.example.batallanaval1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.Node;


public class GameController {

    @FXML
    private GridPane gridPlayer;

    @FXML
    private HBox hbxHead;

    @FXML
    private Label lblTitle;

    @FXML
    private Pane paneBaseA;
    @FXML
    private Pane paneBaseB;

    private int parentWidth = 682;  // Ancho del AnchorPane
    private int parentHeight = 408; // Alto del AnchorPane

    public void initialize() {
        // Inicializa los elementos necesarios
    }

    public void setGridPlayer(GridPane gridPlayer) {
        this.gridPlayer = gridPlayer;
        initializeGrid();
    }
    private void initializeGrid() {
        for (Node node : gridPlayer.getChildren()) {
            Integer colIndex = GridPane.getColumnIndex(node);
            Integer rowIndex = GridPane.getRowIndex(node);
            if (colIndex != null && rowIndex != null) {
                gridPlayer.add(node, colIndex, rowIndex);
            }
        }

    }
}
