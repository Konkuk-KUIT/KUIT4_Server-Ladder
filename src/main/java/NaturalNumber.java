public class NaturalNumber {
    private int naturalNumber;

    private NaturalNumber(int naturalNumber) throws NaturalNumberException {
        if (naturalNumber < 1) {
            throw new NaturalNumberException(naturalNumber);
        }
        this.naturalNumber = naturalNumber;
    }
    public static NaturalNumber from(int i) throws NaturalNumberException {
        return new NaturalNumber(i);
    }

    public int getNaturalNumber() {
        return naturalNumber;
    }
}