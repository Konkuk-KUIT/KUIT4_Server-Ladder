import java.io.IOException;

public class Matrix {
    private final int[][] rows;
    private final NaturalNum row, numberOfPerson; // y, x

    // make ladder (row : height of ladder, col : numberOfPerson) (while checking parameter being naturalNum)
    public Matrix(NaturalNum row, NaturalNum numberOfPerson) {
        this.row = row;
        this.numberOfPerson = numberOfPerson;
        rows = new int[row.getNaturalNum()][numberOfPerson.getNaturalNum()];
    }

    public NaturalNum getRow() {
        return row;
    }

    public NaturalNum getNumberOfPerson() {
        return numberOfPerson;
    }

    public int getRowsLength() {
        return rows.length * rows[0].length;
    }

    public int getIntRow() {
        return row.getNaturalNum();
    }

    public int getIntNumberOfPerson() {
        return numberOfPerson.getNaturalNum();
    }

    public void setDirection(int x, int y, int direction) {
        rows[y][x] = direction;
        rows[y][x + 1] = -direction;
    }

    public int returnMatrixValue(int x, int y) {
        return rows[y][x]; // 이미 -1 되었음
    }

    public int runLadder(NaturalNum x)  {
        int starter = x.getNaturalNum() - 1;
        int currentRow = 0;
        int finalLine = 0;


        while (currentRow < row.getNaturalNum()) { // 높이 만큼 반복
            // 양쪽 끝일 때는?
            switch (rows[currentRow][starter]) {
                case 0:
                    currentRow = moveDown(currentRow); // move to down
                    break;

                case 1: // 일단 오른쪽으로 가면 다음은 무조건 내려가야 함
                    starter = moveRight(starter);
                    currentRow = moveDown(currentRow);
                    break;

                case -1: // 일단 왼쪽으로 가면 다음은 무조건 내려가야 함
                    starter = moveLeft(starter);
                    currentRow = moveDown(currentRow);
                    break;

                default:
                    throw new IllegalArgumentException("There is unacceptable value in ladder");
            }
        }

        finalLine = starter + 1;
        return finalLine; // 1부터 시작하므로
    }

    public int moveDown(int currentRow) {
        return ++currentRow;
    }

    public int moveRight(int starter) {
        if (starter >= numberOfPerson.getNaturalNum()-1) {
            return starter;
        }
        return ++starter;
    }

    public int moveLeft(int starter) {
        if (starter <= 0) {
            return starter;
        }
        return --starter;
    }

    public void printLadder() {
        for(int i = 0; i < row.getNaturalNum(); i++) {
            for (int j = 0; j < numberOfPerson.getNaturalNum(); j++) {
                System.out.print(rows[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-".repeat(10));
    }


}
