package ladder;

public class GreaterThanOne {

    private final int number;

    private GreaterThanOne(int number) {
        this.number = number;
    }

    public static GreaterThanOne from(int number) {
        if (!isGreaterThanOne(number)) {
            throw new IllegalArgumentException("2 이상의 수가 아닙니다.");
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
