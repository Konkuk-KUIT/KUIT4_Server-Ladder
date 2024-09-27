package ladder;

import static ladder.ExceptionMessage.INVALID_LADDER_POSITION;

public class Position {
   /* private int position;  // x 좌표만 관리

    // 생성자에서 x 좌표만 초기화
    private Position(int position) {
        this.position = position;
    }

    // 현재 x 좌표 값을 반환
    public int getValue() {
        return position;
    }

    // Position 객체를 생성하는 정적 메서드 (x 값만 사용)
    public static Position from(int position) {
        if (position < 0) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
        return new Position(position);
    }

    // 좌측으로 이동 (x 값을 감소)
    public void prev() {
        position--;
    }

    // 우측으로 이동 (x 값을 증가)
    public void next() {
        position++;
    }

    // x 좌표가 입력된 값보다 작은지 확인
    public boolean isSmallerThan(int position) {
        return this.position < position;
    }

    // x 좌표가 입력된 값보다 큰지 확인
    public boolean isBiggerThan(int position) {
        return this.position > position;
    }*/

}
