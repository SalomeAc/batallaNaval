package org.example.batallanaval1;
import org.example.batallanaval1.model.FileCRUD;
import org.example.batallanaval1.view.StartStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class main extends Application {

    public static void main(String[] args) {
        FileCRUD fileCRUD = new FileCRUD("data.txt");
        fileCRUD.createFile("");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        StartStage.getInstance();
    }
}
