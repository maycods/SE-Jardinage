package GUI;

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

}
