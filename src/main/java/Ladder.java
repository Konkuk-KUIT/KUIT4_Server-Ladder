import java.util.Random;
import java.util.Scanner;

public class Ladder {

    Scanner scanner = new Scanner(System.in);

    private final int[][] rows;
    private final int row;
    private final int column;

    public Ladder(int row, int numberOfPerson) {
        this.row = row;
        this.column = numberOfPerson;
        this.rows = new int[row][numberOfPerson];
    }

    public void drawLine(int numberOfLine) throws IllegalArgumentException {
        int x, y;
        for (int i = 0; i < numberOfLine; i++) {
            System.out.print("Input your line (MAX 3), (Rule is 1 2, ExitCode is -1): ");
            x = scanner.nextInt();
            y = scanner.nextInt();

            if (x == -1 || y == -1) {
                throw new IllegalArgumentException("Exit code entered.");
            }

            if (x < 1 || x > rows.length || y < 1 || y > rows.length || Math.abs(x - y) != 1) {
                throw new IllegalArgumentException("Invalid input. x and y must be between 1");
            }

            new Line(x, y, i, rows);
        }
    }


    int run(int start) {

        int currentRow=0;
        int currentCol=start;
        while(true) {
            if (rows[currentRow][currentCol]==1&&currentCol + 1 < rows[currentRow].length && rows[currentRow][currentCol + 1] == 1) {
                // j+1이 배열의 범위를 벗어나지 않을 때만 실행
                currentCol++;
            }
            else if (rows[currentRow][currentCol]==1&&currentCol - 1 >= 0 && rows[currentRow][currentCol- 1] == 1) {
                // j-1이 음수가 아닐 때만 실행
                currentCol--;
            }
            else if(currentRow==this.row-1) {
                break;
            }
            currentRow++;
        }
        return currentCol;
    }

    public int[][] getRows() {
        return rows;
    }

}
