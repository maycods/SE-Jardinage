package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setHeight(650);
        stage.setWidth(655);
        stage.setTitle("Plants Advisor");
        stage.setScene(scene);
        stage.show();

        Button check = (Button) scene.lookup("#check");
        ChoiceBox drainage = (ChoiceBox) scene.lookup("#drainage");
        ChoiceBox soleil = (ChoiceBox)scene.lookup("#soleil");
        ChoiceBox saison = (ChoiceBox)scene.lookup("#season");
        ChoiceBox espace = (ChoiceBox)scene.lookup("#espace");
        ChoiceBox eau = (ChoiceBox) scene.lookup("#eau");
        ChoiceBox ph = (ChoiceBox) scene.lookup("#ph");
        ChoiceBox plants = (ChoiceBox) scene.lookup("#plant");
        soleil.getItems().addAll(Soleil.values());
        saison.getItems().addAll(Saison.values());
        espace.getItems().addAll(Espace.values());
        eau.getItems().addAll(Eau.values());
        ph.getItems().addAll(PH.values());
        plants.getItems().addAll(Plant.values());


        drainage.getItems().addAll(Drainage.values());
    }

    public static void main(String[] args) {
        launch();
    }
}