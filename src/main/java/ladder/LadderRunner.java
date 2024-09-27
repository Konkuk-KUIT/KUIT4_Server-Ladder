package ladder;

import java.util.Arrays;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Before");
            printRows(position.getValue(), i);

            rows[i].nextPosition(position);

            System.out.println("After");
            printRows(position.getValue(), i);
        }
        return position.getValue();
    }

    private void printRows(int moveX, int moveY) {
        for (int i = 0; i < rows.length; i++) {
            printRow(i, moveX, moveY);
        }
        System.out.println();
    }

    private void printRow(int rowIndex, int moveX, int moveY) {
        int[] values = rows[rowIndex].getRowValue();
        for (int j = 0; j < rows[0].getSize(); j++) {
            String moveCheck = (moveY == rowIndex && moveX == j) ? "* " : " ";
            System.out.print(values[j] + moveCheck);
        }
        System.out.println();
    }
}
