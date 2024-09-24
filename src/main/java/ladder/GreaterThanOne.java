package ladder;

public class GreaterThanOne {

    private final int number;

    public GreaterThanOne(int number) {
        this.number = number;
    }

    public static GreaterThanOne from(int number) {
        if (!isGreaterThanOne(number)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }
        return new GreaterThanOne(number);
    }

    private static boolean isGreaterThanOne(int number) {
        return number > 1;
    }

    public int getNumber() {
        return number;
    }
}
