public enum ExceptionMessage {

    INVALID_LADDER_SIZE("사다리의 열과 행은 2이상의 자연수입니다."),
    INVALID_LINE_POSITION("선의 위치가 사다리를 벗어납니다."),
    INVALID_START_POSITION("출발 위치는 1이상의 자연수입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
