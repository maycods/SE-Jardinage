package GUI;

import java.util.ArrayList;

public enum Saison {
    Chaud("Chaud"),
    Froid("Froid"),
    Tempere("Tempéré"),
    ;
    private String s;

    Saison(String s){
    this.s = s;
    }
    public String getValue(){
        return s;
    }
    public static ArrayList<String> getVals(){
        ArrayList<String> vals = new ArrayList<>();
        for(Saison s : Saison.values()){
            vals.add(s.getValue());
        }
        return vals;
    }
}
