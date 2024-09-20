public class NaturalNumber {
    private int naturalNumber;

    public NaturalNumber(int naturalNumber) {
        if(naturalNumber < 0) {
            throw new IllegalArgumentException("Natural number cannot be negative");
        }
        this.naturalNumber = naturalNumber;
    }

    public int getNaturalNumber() {
        return naturalNumber;
    }
    public static NaturalNumber from(int i){
        return new NaturalNumber(i);
    }

}
