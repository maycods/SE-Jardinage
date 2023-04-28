package GUI;

import Main.MoteurInference;
import Main.Regle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        saison.getItems().addAll(Saison.getVals());
        espace.getItems().addAll(Espace.getVals());
        eau.getItems().addAll(Eau.getVals());
        ph.getItems().addAll(PH.getVals());
        plants.getItems().addAll(Plant.getVals());
        drainage.getItems().addAll(Drainage.getVals());

        check.setOnAction(event -> {

            ButtonType okButton = new ButtonType("OK");

            //check if the hasn't been selected
            if (drainage.getValue() == null || soleil.getValue() == null || saison.getValue() == null
                    || espace.getValue() == null || eau.getValue() == null || ph.getValue() == null || plants.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Champ(s) vide(s) !");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs");

                alert.getButtonTypes().setAll(okButton);
                Image iconImage = new Image("file:C:/Users/mayah/Documents/GitHub/demo/src/main/resources/icon.png");
                ImageView iconImageView = new ImageView(iconImage);
                iconImageView.setFitWidth(48);
                iconImageView.setFitHeight(48);
                alert.setGraphic(iconImageView);

                javafx.scene.control.DialogPane dialogPane = alert.getDialogPane();

                // Apply custom CSS styles to the dialog pane
                dialogPane.setStyle("-fx-background-color: white ");
                dialogPane.lookupButton(okButton).setStyle("-fx-base: #bedb99 ;-fx-text-fill: #083b32");

                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {

                    }
                });

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

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("plante validée");
                    alert.setHeaderText(null);
                    alert.setContentText("Oui! vous pouvez planter le "+plants.getValue()+" dans votre jardin");

                    alert.getButtonTypes().setAll(okButton);
                    Image iconImage = new Image("file:C:/Users/mayah/Documents/GitHub/demo/src/main/resources/icon.png");
                    ImageView iconImageView = new ImageView(iconImage);
                    iconImageView.setFitWidth(48);
                    iconImageView.setFitHeight(58);
                    alert.setGraphic(iconImageView);

                    javafx.scene.control.DialogPane dialogPane = alert.getDialogPane();


                    dialogPane.setStyle("-fx-background-color: white ");
                    dialogPane.lookupButton(okButton).setStyle("-fx-base: #bedb99 ;-fx-text-fill: #083b32");
                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {

                        }
                    });

                }else {
                    result.setFill(Color.WHITE);
                    result.setText("False !");

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("plante non validée");
                    alert.setHeaderText(null);
                    if( !chainAv.PossiblePlants.isEmpty()) {
                        alert.setContentText("Non, il est deconseiller de planter le " + plants.getValue() + " dans votre jardin mais " +
                                " vous pouvez planter " + chainAv.PossiblePlants.toString() );
                    }else{
                        alert.setContentText("Non, il est deconseiller de planter le " + plants.getValue() + " dans votre jardin mais " +
                                " vous ne pouvez planter aucune autre plantes non plus");
                    }
                    alert.getButtonTypes().setAll(okButton);
                    Image iconImage = new Image("file:C:/Users/mayah/Documents/GitHub/demo/src/main/resources/icon.png");
                    ImageView iconImageView = new ImageView(iconImage);
                    iconImageView.setFitWidth(48);
                    iconImageView.setFitHeight(58);
                    alert.setGraphic(iconImageView);

                    javafx.scene.control.DialogPane dialogPane = alert.getDialogPane();

                    // Apply custom CSS styles to the dialog pane
                    dialogPane.setStyle("-fx-background-color: white ");
                    dialogPane.lookupButton(okButton).setStyle("-fx-base: #bedb99 ;-fx-text-fill: #083b32");

                    alert.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {

                        }
                    });

                }
            }
        });
    }
    private static ArrayList<Regle> loadRegles(){

        ArrayList<Regle> br = new ArrayList<>();

        br.add(new Regle(new ArrayList<>(Arrays.asList("Ombre partielle","Mal drainé")), "BesoinOmbre", 22));//rouge ete->1
        br.add(new Regle(new ArrayList<>(Arrays.asList("Plein soleil","Bien drainé", "Chaud")), "ToleranteSechresse", 23));///gris ph->1 rare->1 grand ->1
        br.add(new Regle(new ArrayList<>(Arrays.asList("Plein soleil","Ph<6", "Chaud","Grand")), "BesoinChaleur", 24));//c bon blue
        br.add(new Regle(new ArrayList<>(Arrays.asList("Plein soleil","Bien drainé","Ph<6")), "BesoinAcidite", 25));//orange   petit 1
        br.add(new Regle(new ArrayList<>(Arrays.asList("Régulier","Ombre partielle","6<Ph<7","Bien drainé")), "BesoinHumidite", 26));//violet ete->1 reste->2
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinChaleur" )), "Pastèque", 21));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinAcidite","Chaud")), "Roses", 15));
            br.add(new Regle(new ArrayList<>(Arrays.asList("ToleranteSechresse")), "Pétunias", 16));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinAcidite","Petit")), "Basilic", 17));
            br.add(new Regle(new ArrayList<>(Arrays.asList("ToleranteSechresse")), "œillets", 18));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinChaleur" )), "Tomates", 19));
            br.add(new Regle(new ArrayList<>(Arrays.asList("ToleranteSechresse", "Grand")), "Géranium", 20));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinHumidite", "Chaud")), "Bégonias", 8));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinHumidite", "Tempéré")), "Epinards", 2));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinHumidite", "Tempéré")), "Laitue", 3));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinAcidite","Tempéré")), "Carottes", 4));
            br.add(new Regle(new ArrayList<>(Arrays.asList("Plein soleil","6<Ph<7","Grand")), "Chou-fleur", 5));
            br.add(new Regle(new ArrayList<>(Arrays.asList("Plein soleil","6<Ph<7","Tempéré")), "Brocoli", 6));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinAcidite","Humide")), "Myrtilles", 7));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinOmbre", "Tempéré")), "Azalées", 8));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinOmbre", "Grand")), "Hostas", 9));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinChaleur" )), "Cannas", 10));
            br.add(new Regle(new ArrayList<>(Arrays.asList("BesoinChaleur" )), "PatateDouce", 11));
            br.add(new Regle(new ArrayList<>(Arrays.asList("ToleranteSechresse","Rarement")), "Cactus", 12));
            br.add(new Regle(new ArrayList<>(Arrays.asList("ToleranteSechresse","Ph>7")), "Aloe vera", 13));
        return br;
    }

    public static void main(String[] args) {
        launch();
    }
}