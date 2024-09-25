package ladder;

public class LadderRunner {

    private final Row[] rows; // 사다리의 한 행을 빼놓았다.
    private StringBuilder ladder = new StringBuilder();

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    // todo 포지션 wrapper 클래스 필요
    // todo LadderRunner로 분리 (Ladder 클래스 책임분산)
    // 매개변수 : 시작 x좌표 / 반복문 : y좌표
    // todo <미션> 여기서 사다리의 움직임마다 출력해야 함
    public int run(Position position) {
        // position (x)좌표는 마지막 위치에 있고
        // for문의 반복으로 y좌표가 움직이면 좌표 다룰 수 있음

        // todo 여기에 (position, 1)로 좌표보내주면 될듯 (setStringLadder()함수)

        for (int i = 0; i < rows.length; i++) {
            // todo <미션1> 사다리 진행상황 출력위치
            // 사다리 (*포함) 세팅
            setStringLadder(new LadderPosition(position, Position.from(i)));
            printLadder();
            rows[i].nextPosition(position);
            setStringLadder(new LadderPosition(position, Position.from(i)));
            printLadder();
        }

        return position.getPosition();
    }

    public void setStringLadder(LadderPosition xy) {
        for (int i = 0; i < rows.length; i++) { // 높이만큼 순환
            rows[i].setStringLadder(xy);
            ladder.append(rows[i].rowLadder); // 한줄 씩 붙이기
        }
    }

    public void printLadder() {
        System.out.println(ladder);
        clearStringLadder();
    }

    public void clearStringLadder() {
        ladder.setLength(0); // 전체 사다리 초기화

        for (int i = 0; i < rows.length; i++) { // 만들었던 사다리 줄 하나씩 초기화
            rows[i].rowLadder.setLength(0);
        }
    }
}
