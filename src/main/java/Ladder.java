public class Ladder {

    private final int[][] rows;

    public Ladder(Row row, NumberOfPerson numberOfPerson) {
        this.rows = new int[row.getRow()][numberOfPerson.getNumberOfPerson()];
    }

    // 반드시 오른쪽에서 왼쪽으로만 사다리를 그리도록 제한
    public void drawLine(Position position) {

        continuousLineVerify(position);
        outOfRangeVerify(position);

        // 맨 왼쪽 라인에는 사다리를 애초에 그리지 않도록 조건문 추가. 별도로 예외 처리는 하지 않음
        if (position.getY() > 0) {
            rows[position.getX()][position.getY()] = -1;
            rows[position.getX()][position.getY() - 1] = 1;
        }

    }

    public void continuousLineVerify(Position position) {
        // 선을 긋고자 하는 좌표의 오른쪽에 이미 사다리가 놓여져있는 경우
        if (position.getY() < rows[0].length - 1 && rows[position.getX()][position.getY() + 1] == -1) {
            throw new IllegalArgumentException("사다리는 연달아서 놓을 수 없습니다.");
        }

        // 선을 긋고자 하는 좌표의 왼쪽에 이미 사다리가 놓여져있는 경우
        if (position.getY() > 1 && rows[position.getX()][position.getY() - 1] == -1) {
            throw new IllegalArgumentException("사다리는 연달아서 놓을 수 없습니다.");
        }
    }

    public void outOfRangeVerify(Position position) {

        // 사다리의 높이를 벗어난 위치에 사다리를 놓고자 하는 경우
        if (position.getX() > rows.length) {
            throw new IllegalArgumentException("사다리의 높이를 벗어난 위치에는 라인을 생성할 수 없습니다.");
        }

        // 사다리의 넓이를 벗어난 위치에 사다리를 놓고자 하는 경우
        if (position.getY() > rows[0].length) {
            throw new IllegalArgumentException("사다리의 넓이를 벗어난 위치에는 라인을 생성할 수 없습니다.");
        }
    }

    public int run(Col startLadder) {

        // 사다리의 넓이를 벗어난 위치에서 게임을 시작하고자 하는 경우 예외 발생
        if (startLadder.getCol() > rows[0].length) {
            throw new IllegalArgumentException("사다리의 넓이를 벗어난 위치에서는 사다리 게임을 시작할 수 없습니다.");
        }

        int currentLadder = startLadder.getCol() - 1;

        // 실제 게임 실행 과정
        for (int[] row : rows) {
            currentLadder += row[currentLadder];
        }

        return currentLadder + 1;
    }

}
