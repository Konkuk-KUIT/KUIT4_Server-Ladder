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

        System.out.println("-".repeat(10));

        return position.getPosition();
    }

    public void setStringLadder(LadderPosition xy) {
        // 점을 한번 찍으면 특정 변수에 변화를 주어서, 다음 줄에서는 *을 찍지 않도록 조치..?

        for (int i = 0; i < rows.length; i++) { // 높이만큼 순환
            // todo 여기서 xy의 y좌표랑 반복문 인자 i랑 같은지 확인하고
            // 같을 때 만 *을 찍을 수 있도록 인자를 넘긴다.
            if (xy.getY() == i) {
                ladder.append(rows[i].setStringStarLadder(xy)); // *을 붙이는 라인
                ladder.append(System.lineSeparator());
                continue;
            }
            ladder.append(rows[i].setStringLadder(xy)); // 일반 사다리 붙이는 라인
            ladder.append(System.lineSeparator());
        }
    }

    public void printLadder() {
        System.out.println(ladder);
        // System.out.println();
        clearStringLadder();
    }

    public void clearStringLadder() {
        ladder.setLength(0); // 전체 사다리 초기화

//        for (int i = 0; i < rows.length; i++) { // 만들었던 사다리 줄 하나씩 초기화
//            rows[i].rowLadder.setLength(0);
//        }
    }
}
