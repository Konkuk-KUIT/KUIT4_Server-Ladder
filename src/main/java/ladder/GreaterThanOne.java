package ladder;

// 1보다 큰지 검증하는 클래스
public class GreaterThanOne {

    private final int number;

    private GreaterThanOne(int number) {
        this.number = number;
    }

    public static GreaterThanOne from(int number) {
        if (! isGreaterThanOne(number)) { // 팩토리 메소드로 검증 (1보다 큰지)
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_NUMBER.getMessage());
        }
        return new GreaterThanOne(number);
    }

    // opt + cmd + m : 드래그 한 부분 새로운 method 생성
    private static boolean isGreaterThanOne(int number) {
        return number > 1;
    }

    public int getNumber() {
        return number;
    }
}
