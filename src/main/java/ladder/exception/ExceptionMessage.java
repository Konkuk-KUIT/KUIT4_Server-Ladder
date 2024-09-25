package ladder.exception;

public enum ExceptionMessage {

    INVALID_LADDER_POSITION("사다리 위치는 1이상 자연수입니다."),
    INVALID_LADDER_NUMBER("사다리의 행과 열은 2 이상이어야 합니다."),
    INVALID_POSITION("유효하지 않은 위치입니다."),
    INVALID_DRAW_POSITION("사다리를 그릴 수 없는 위치입니다."),
    INVALID_NATURAL_NUMBER("자연수가 아닙니다."),
    INVALID_LADDER_DRAW_AUTO("선택하신 사다리는 자동사라디이므로 사다리의 선을 그릴수 없습니다."),
    INVALID_LADDER_DRAW_INPUT("선택하신 사다리는 사용자입력사라디이므로 사다리의 선을 직접 그려야합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
