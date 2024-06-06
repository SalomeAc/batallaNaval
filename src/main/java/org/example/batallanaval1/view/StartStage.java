package org.example.batallanaval1.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartStage extends Stage {

    private StartStage startStage;

    public StartStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/batallanaval1/start-naval-battle-view.fxml"));
        Parent parent =loader.load();
        setTitle("Naval Battle");
        Scene scene = new Scene(parent);
        setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/org/example/batallanaval1/NavalBattleStyles.css").toExternalForm());
        getIcons().add(
                new Image(
                        String.valueOf(getClass().getResource("/org/example/batallanaval1/images/favicon.png"))));
        setResizable(false);
        show();
    }
    private static class StartStageHolder{
        private static StartStage INSTANCE;
    }
    public static StartStage getInstance() throws IOException {
        return StartStageHolder.INSTANCE=new StartStage();
    }
    public static void deleteInstance(){
        StartStageHolder.INSTANCE=null;
    }
}