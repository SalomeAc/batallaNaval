package org.example.batallanaval1.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {
    private GameStage gameStage;

    public GameStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/batallanaval1/game-naval-battle.fxml"));

        Parent parent =loader.load();
        setTitle("Naval Battle");
        getIcons().add(
                new Image(

                        String.valueOf(getClass().getResource("/org/example/batallanaval1/Images/favicon.png"))));



        Scene scene = new Scene(parent);
        setScene(scene);

        scene.getStylesheets().add(getClass().getResource("/org/example/batallanaval1/NavalBattleStyles.css").toExternalForm());

        setResizable(false);
        show();
    }
    private static class GameStageHolder{
        private static GameStage INSTANCE;
    }

    public static GameStage getInstance(GridPane gridPlayer1) throws IOException {

        return GameStageHolder.INSTANCE=new GameStage();
    }
    public static void deleteInstance(){
        GameStage.GameStageHolder.INSTANCE.close();
        GameStage.GameStageHolder.INSTANCE=null;
    }

}

