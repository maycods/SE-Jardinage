package GUI;

import java.util.ArrayList;

public enum Soleil {
    PleinSoleil("Plein soleil"),
    OmbrePartielle("Ombre partielle"),
    OmbreTotale("Ombre totale"),
;
    private String s;
    Soleil(String s) {
        this.s=s;
    }
    public String getValue(){
        return s;
    }
    public static ArrayList<String> getVals(){
        ArrayList<String> vals = new ArrayList<>();
        for(Soleil s : Soleil.values()){
            vals.add(s.getValue());
        }
        return vals;
    }
}
