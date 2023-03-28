package Main;
import java.util.ArrayList;
import java.util.Comparator;
public class MoteurInference {

        ArrayList<String> BDF ;
        ArrayList<Regle>BR ;
        ArrayList<Regle>RA =new ArrayList<Regle>();

        public MoteurInference( ArrayList<String> bdf,ArrayList<Regle> br){
            BDF=bdf;
            BR=br;
        }
        public Boolean raisonnement(String a){
            Regle r ;
            while(!BDF.contains(a) && !BR.isEmpty() && Applicable() ){

                RA.sort(new Comparator<Regle>() {
                    @Override
                    public int compare(Regle o1, Regle o2) {

                        return o1.premise.size()>o2.premise.size()? -1:((o1.premise.size()<o2.premise.size()?1:(o1.indice>o2.indice?1:-1) )   );
                    }
                });
                r  = RA.get(0);

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

