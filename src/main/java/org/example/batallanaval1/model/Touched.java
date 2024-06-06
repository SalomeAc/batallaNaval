package org.example.batallanaval1.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 * Utility class for managing 'touched' images.
 */
public class Touched {
    private static final String TOCADO_IMAGE_URL = "/org/example/batallanaval1/Images/target.png";

    private static final int MAX_TOCADO = 20;

    private static int counter = 0;

    /**
     * Adds a 'touched' image to the specified StackPane.
     *
     * @param stackPane the StackPane to which the 'touched' image will be added
     */
    public static void addTocado(StackPane stackPane) {
        if (counter < MAX_TOCADO) {
            Image tocadoImage = new Image(Touched.class.getResource(TOCADO_IMAGE_URL).toExternalForm());
            ImageView imageView = new ImageView(tocadoImage);

            //Se establece manualmente el tamaño
            double imageWidth = 30;
            double imageHeight = 30;
            imageView.setFitWidth(imageWidth);
            imageView.setFitHeight(imageHeight);

            //ImageView al StackPane
            stackPane.getChildren().add(imageView);
            counter++;
        } else {
            System.out.println("El contador ha alcanzado el limite de 20.");
        }

    }
    /**
     * Checks if the maximum counter has been reached.
     *
     * @return true if the maximum counter has been reached, false otherwise
     */
    public static boolean maximumCounter() {
        return counter >= MAX_TOCADO;
    }
}
