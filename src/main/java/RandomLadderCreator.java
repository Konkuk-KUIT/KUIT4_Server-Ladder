import java.util.Random;

public class RandomLadderCreator implements LadderCreator {
    private Random random = new Random();

    @Override
    public Ladder createLine(int rows, int columns) {
        Ladder ladder = new Ladder(rows, columns);
        int totalLines = (int) (rows * (columns - 1) * 0.3);
        int createdLines = 0;

        while (createdLines < totalLines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(columns - 1);

            if (canAddLine(ladder, row, col)) {
                ladder.addLine(col, col + 1, row);
                createdLines++;
            }
        }

        return ladder;
    }

    boolean canAddLine(Ladder ladder, int row, int col) {
        // 현재 선택된 위치에 이미 가로선이 있는지 확인
        if (ladder.isLine(row, col)) {
            return false;
        }
        // 현재 위치의 왼쪽에 가로선이 있는지를 확인
        if (col > 0 && ladder.isLineAtLeft(row, col)) {
            return false;
        }
        // 현재 위치의 오른쪽에 가로선이 있는지를 확인
        if (col < ladder.getWidth() - 1 && ladder.isLineAtRight(row, col)) {
            return false;
        }
        // 마지막 열에는 선이 생성되지 않습니다
        if  (row >= ladder.getHeight() - 1){
            return false;
        }
        return true;
    }


}