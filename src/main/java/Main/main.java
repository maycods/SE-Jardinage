package Main;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String args[]){

        ArrayList<Regle> br = new ArrayList();
        br.add(new Regle(new ArrayList(Arrays.asList("Bien drainé","6<Ph<7", "Régulier")), "classe1", 0));
        br.add(new Regle(new ArrayList(Arrays.asList("Ph<6", "Mal drainé", "Humide")), "classe2", 1));
        br.add(new Regle(new ArrayList(Arrays.asList("classe1", "Plein soleil")), "catégorieA", 2));
        br.add(new Regle(new ArrayList(Arrays.asList("Chaud", "Plein soleil", "bien drainé", "Grand")), "classe4", 3));
        br.add(new Regle(new ArrayList(Arrays.asList("ph<6", "Humide", "Petit" )), "classe3", 4));
        br.add(new Regle(new ArrayList(Arrays.asList("classe3", "Grand" )), "Pastèque", 5));
        br.add(new Regle(new ArrayList(Arrays.asList("classe3", "Modérément drainé" )), "Gingembre", 6));
        br.add(new Regle(new ArrayList(Arrays.asList("catégorieA", "Tempéré")), "Roses", 7));
        br.add(new Regle(new ArrayList(Arrays.asList("catégorieA", "Tempéré")), "Pétunias", 7));
        br.add(new Regle(new ArrayList(Arrays.asList("catégorieA", "Chaud")), "Basilic", 7));
        br.add(new Regle(new ArrayList(Arrays.asList("catégorieA", "Chaud")), "œillets", 7));
        br.add(new Regle(new ArrayList(Arrays.asList("catégorieA", "Chaud")), "Tomates", 7));
        br.add(new Regle(new ArrayList(Arrays.asList("classe4", "Humide")), "Géranium", 8));

        br.add(new Regle(new ArrayList(Arrays.asList("classe1", "Ombre partielle")), "Bégonias", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("classe1", "Ombre partielle")), "Epinards", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("classe1", "Ombre partielle")), "Laitue", 8));


        br.add(new Regle(new ArrayList(Arrays.asList("catégoriea", "Froid")), "Carottes", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("catégoriea", "Froid")), "Chou-fleur", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("catégoriea", "Froid")), "Brocoli", 8));


        br.add(new Regle(new ArrayList(Arrays.asList("classe2", "Tempéré")), "Myrtilles", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("classe2", "Tempéré")), "Azalées", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("classe2", "Tempéré")), "Hostas", 8));

        br.add(new Regle(new ArrayList(Arrays.asList("classe2", "Chaud")), "Cannas", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("classe2", "Chaud")), "PatateDouce", 8));

        br.add(new Regle(new ArrayList(Arrays.asList("classe4","Rarement")), "Cactus", 8));
        br.add(new Regle(new ArrayList(Arrays.asList("classe4","Rarement")), "Aloe vera", 8));

        ArrayList<String> bdf = new ArrayList(Arrays.asList("Rarement", "chaud", "Plein soleil", "bien drainé", "Grand"));
        MoteurInference chainAv = new MoteurInference(bdf, br);
        System.out.println(chainAv.raisonnement("Cactus"));
    }
}
