package GUI;

public enum PH {
    Tres_Acid(1, "Very Acidic"),
    Moderement_ACIDIC(2, "Moderately Acidic"),
    Neutre(7, "Neutral"),
    Moderement_Alkaline(12, "Moderately Alkaline"),
    Tres_Alkaline(14, "Very Alkaline");

    private int value;
    private String label;

    PH(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
