package GUI;

import Main.MoteurInference;
import Main.Regle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setHeight(675);
        stage.setWidth(655);
        stage.setTitle("Plants Advisor");
        Image icon = new Image("file:C:/Users/mayah/Documents/GitHub/demo/src/main/resources/icon.png"); // Replace "icon.png" with your actual icon image file
        stage.getIcons().add(icon);
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

        Text result = (Text) scene.lookup("#result");
        soleil.getItems().addAll(Soleil.getVals());
        System.out.println(Soleil.getVals());
        saison.getItems().addAll(Saison.getVals());
        espace.getItems().addAll(Espace.getVals());
        eau.getItems().addAll(Eau.getVals());
        ph.getItems().addAll(PH.getVals());
        plants.getItems().addAll(Plant.getVals());
        drainage.getItems().addAll(Drainage.getVals());

        check.setOnAction(event -> {

            //check if the hasn't been selected
            if (drainage.getValue() == null || soleil.getValue() == null || saison.getValue() == null
                    || espace.getValue() == null || eau.getValue() == null || ph.getValue() == null || plants.getValue() == null) {
                result.setFill(Color.WHITE);
                result.setText("Veuillez remplir tous les champs");
                return;
            }
            var br = loadRegles();
            ArrayList<String> bdf = new ArrayList(Arrays.asList(drainage.getValue(), soleil.getValue(), saison.getValue()
                    , espace.getValue(), eau.getValue(), ph.getValue()));
            MoteurInference chainAv = new MoteurInference(bdf, br);
            if (chainAv.raisonnement(plants.getValue().toString()) == null){
                result.setFill(Color.WHITE);
            result.setText("Pas de plantes trouvées");
        }else{
                if(chainAv.raisonnement(plants.getValue().toString())){
                    result.setFill(Color.WHITE);
                    result.setText("True !");
                }else {
                    result.setFill(Color.WHITE);
                    result.setText("False !");
                }
            }
        });
    }
    private static ArrayList<Regle> loadRegles(){

        ArrayList<Regle> br = new ArrayList<>();
        br.add(new Regle(new ArrayList<>(Arrays.asList("Bien drainé","6<Ph<7", "Régulier")), "classe1", 0));
        br.add(new Regle(new ArrayList<>(Arrays.asList("Ph<6", "Mal drainé", "Humide")), "classe2", 1));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe1", "Plein soleil")), "catégorieA", 2));
        br.add(new Regle(new ArrayList<>(Arrays.asList("Chaud", "Plein soleil", "Bien drainé", "Grand")), "classe4", 3));
        br.add(new Regle(new ArrayList<>(Arrays.asList("ph<6", "Humide", "Petit" )), "classe3", 4));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe3", "Grand" )), "Pastèque", 5));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe3", "Modérément drainé" )), "Gingembre", 6));
        br.add(new Regle(new ArrayList<>(Arrays.asList("catégorieA", "Tempéré")), "Roses", 7));
        br.add(new Regle(new ArrayList<>(Arrays.asList("catégorieA", "Tempéré")), "Pétunias", 7));
        br.add(new Regle(new ArrayList<>(Arrays.asList("catégorieA", "Chaud")), "Basilic", 7));
        br.add(new Regle(new ArrayList<>(Arrays.asList("catégorieA", "Chaud")), "œillets", 7));
        br.add(new Regle(new ArrayList<>(Arrays.asList("catégorieA", "Chaud")), "Tomates", 7));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe4", "Humide")), "Géranium", 8));

        br.add(new Regle(new ArrayList<>(Arrays.asList("classe1", "Ombre partielle")), "Bégonias", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe1", "Ombre partielle")), "Epinards", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe1", "Ombre partielle")), "Laitue", 8));


        br.add(new Regle(new ArrayList<>(Arrays.asList("catégoriea", "Froid")), "Carottes", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("catégoriea", "Froid")), "Chou-fleur", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("catégoriea", "Froid")), "Brocoli", 8));


        br.add(new Regle(new ArrayList<>(Arrays.asList("classe2", "Tempéré")), "Myrtilles", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe2", "Tempéré")), "Azalées", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe2", "Tempéré")), "Hostas", 8));

        br.add(new Regle(new ArrayList<>(Arrays.asList("classe2", "Chaud")), "Cannas", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe2", "Chaud")), "PatateDouce", 8));

        br.add(new Regle(new ArrayList<>(Arrays.asList("classe4","Rarement")), "Cactus", 8));
        br.add(new Regle(new ArrayList<>(Arrays.asList("classe4","Rarement")), "Aloe vera", 8));
        return br;
    }

    public static void main(String[] args) {
        launch();
    }
}