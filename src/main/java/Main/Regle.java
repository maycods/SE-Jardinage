package Main;

import java.util.ArrayList;

public class    Regle {
    ArrayList<String> premise;
    String conclusion;
    int indice ;

    public Regle(ArrayList<String> premise,String conclusion,int indice) {
        this.premise = premise;
        this.conclusion = conclusion;
        this.indice=indice;
    }
}
