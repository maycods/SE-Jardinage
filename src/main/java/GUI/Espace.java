package GUI;

import java.util.ArrayList;

public enum Espace {
    Grand("Grand"),
    Petit("Petit"),
    ;
    private String s;
    Espace(String s){
this.s =s;
    }
    public String getValue(){
        return toString();
    }
    public static ArrayList<String>getVals(){
        ArrayList<String> vals = new ArrayList<>();
        for (Espace e : Espace.values()){
            vals.add(e.getValue());
        }
        return vals;
    }
}
