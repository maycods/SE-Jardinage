package GUI;

import java.util.ArrayList;

public enum Eau {
    Humide("Humide"),
    Regulier("Régulier"),
    Rarement("Rarement"),;
    private String s;
    Eau(String s ){
this.s = s;
    }
    public String getValue(){
        return s;
    }
    public static ArrayList<String>getVals(){
        ArrayList<String> vals = new ArrayList<>();
        for(Eau e : Eau.values()){
            vals.add(e.getValue());
        }
        return vals;
    }

}
