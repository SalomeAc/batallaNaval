package org.example.batallanaval1.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.example.batallanaval1.controller.GameController;
import org.example.batallanaval1.model.Ship;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameStage extends Stage {
    private GameController gameController;

    public GameStage() throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/org/example/batallanaval1/game-view.fxml"));
        Parent root = loader.load();
        gameController=loader.getController();
        Scene scene = new Scene(root);
        setTitle("Batalla naval");
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/org/example/batallanaval1/images/favicon.png"))));

        List<Ship> shipsArray = new ArrayList<>();




        setResizable(false);
        setScene(scene);
        show();
    }
    public static GameStage getInstance() throws IOException {
        return  GameStageHolder.INSTANCE =new GameStage();
    }
    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }
    public static  void deleteInstance () {
        GameStageHolder.INSTANCE.close();
        GameStageHolder.INSTANCE = null;
    }

}