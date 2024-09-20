public class NaturalNumber {
    private int naturalNumber;
    //alt+insert 하면 생성자 쉽게 가능
    public NaturalNumber(int naturalNumber) {
        if(naturalNumber<0){
            try {
                throw new IllegalAccessException("Invalid deposit amount");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        this.naturalNumber = naturalNumber;

    }
    public int getNaturalNumber() {
        return naturalNumber;
    }
}
