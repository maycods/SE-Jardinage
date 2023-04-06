package GUI;

import java.util.ArrayList;

public enum Plant {
    Bégonias("Bégonias"),
    Epinards("Epinards"),
    Laitue("Laitue"),
    Carottes("Carottes")
    ,Chou_fleur("Chou-fleur"),
    Brocoli("Brocoli")
    ,Myrtilles("Myrtilles"),
    Azalées("Azalées") ,
    Hostas("Hostas") ,
    Cannas("Cannas") ,
    PatateDouce("PatateDouce") ,
    Cactus("Cactus") ,
    Aloe_vera("Aloe vera") ,
    Gingembre("Gingembre") ,
    Roses("Roses") ,
    Pétunias("Pétunias")
    ,Basilic("Basilic")
    ,œillets("œillets"),
    Tomates("Tomates") ,
    Géranium("Géranium") ,
    Pastèque("Pastèque"),;

    private String s;
    Plant(String s){
        this.s = s;
    }
    public String getValue(){
        return s;
    }
    public static ArrayList<String> getVals(){
        ArrayList<String> vals = new ArrayList<>();
        for(Plant p : Plant.values()){
            vals.add(p.getValue());
        }
        return vals;
    }

}
