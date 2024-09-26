package ladder.constants;

public enum PrintTiming {

    BEFORE("Before"), AFTER("After");

    private String timing;

    PrintTiming(String timing){
        this.timing = timing;
    }

    public String get(){
        return timing;
    }

}
