package GUI;

import java.util.ArrayList;

public enum PH {
    Acide( "Ph>7"),
    Neutre( "6<Ph<7"),
    Alkaline( "Ph<6"),
    ;

    private int value;
    private String label;

    PH( String label) {
        this.label = label;
    }
    public String getValue(){
        return label;
    }

    public static ArrayList<String> getVals(){
        ArrayList<String> vals = new ArrayList<>();
        for (PH ph : PH.values()) {
            vals.add(ph.getValue());
        }
        return vals;
    }
}
