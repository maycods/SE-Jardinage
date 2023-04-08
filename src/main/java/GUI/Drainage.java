package GUI;

import java.util.ArrayList;

public enum Drainage {
    BienDrainé("Bien drainé"),
    MalDrainé("Mal drainé"),
    ModérémentDrainé("Modérément drainé"),
    ;
    private final String s;

    Drainage(String s) {
        this.s = s;
    }

    public String getValue(){
        return s;
    }
    public static ArrayList<String> getVals(){
        ArrayList<String> vals = new ArrayList<>();
        for(Drainage d : Drainage.values()){
            vals.add(d.getValue());
        }
        return vals;

    }
}
