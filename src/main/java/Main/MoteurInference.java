package Main;
import java.util.ArrayList;
public class MoteurInference {

        ArrayList<String> BDF ;
        ArrayList<Regle>BR ;
        ArrayList<Regle>RA =new ArrayList<Regle>();
       public ArrayList<String>PossiblePlants =new ArrayList<String>();

        public MoteurInference( ArrayList<String> bdf,ArrayList<Regle> br){
            BDF=bdf;
            BR=br;
        }
        public Boolean raisonnement(String a){
            Regle r ;
            while(!BDF.contains(a) && !BR.isEmpty() && Applicable() ){

                RA.sort((o1, o2) -> (o1.premise.size()<o2.premise.size()?1:(o1.indice<o2.indice? 1:(o1.premise.size()>o2.premise.size()? -1:0))     ));
                r  = RA.get(0);
                if(r.indice <22) PossiblePlants.add(r.conclusion);
                BDF.add(r.conclusion);

                BR.remove(r);
                RA.clear();

            }
            return BDF.contains(a);
        }
        public Boolean Applicable(){
            int i=0,j;
            Boolean  b=false;

            while(i<BR.size()){
                j=0;
                while(j<BR.get(i).premise.size() && BDF.contains(BR.get(i).premise.get(j))) {
                    j++;
                }
                if(j>=BR.get(i).premise.size() ) {
                    RA.add(BR.get(i));
                    b= true;
                }
                i++;
            }

            return b;
        }

}

