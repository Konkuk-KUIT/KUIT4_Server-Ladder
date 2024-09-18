public class UnsignedInteger {
    private int unsignedInteger;

    private UnsignedInteger(int unsignedInteger) {
        if (unsignedInteger < 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }

        this.unsignedInteger = unsignedInteger;
    }

    public static UnsignedInteger from(int i) {
        return new UnsignedInteger(i);
    }

    public int getUnsignedInteger() {
        return unsignedInteger;
    }
}