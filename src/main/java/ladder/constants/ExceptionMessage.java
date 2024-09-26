package ladder.constants;

public enum ExceptionMessage {

    INVALID_LADDER("유효하지 않은 사다리입니다."),
    INVALID_STARTING_POSITION("유효하지 않은 시작 위치입니다."),
    INVALID_DRAW_POSITION("사다리를 그릴 수 없는 위치입니다."),
    INVALID_NATURAL_NUMBER("자연수가 아닙니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
