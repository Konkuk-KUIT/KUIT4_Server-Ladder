public class NaturalNumberException extends Exception{
    public NaturalNumberException(int i) {
        super(i + "Is not a natural number");
    }
}
