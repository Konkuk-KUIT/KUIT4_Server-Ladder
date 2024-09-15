public class unsignedInteger {
    int value;

    public unsignedInteger(int value) {
        if(value < 0){
            throw new IllegalArgumentException("Negative number");
        }
        this.value = value;
    }

    public static unsignedInteger from(int value){
        return new unsignedInteger(value);
    }

    public int getValue() {
        return this.value;
    }

}
