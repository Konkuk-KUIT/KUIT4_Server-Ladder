import java.util.ArrayList;
import java.util.List;

class Ladder {
private final int[][] rows;
private final List<Line> lines;

public Ladder(int row, int column) {
    validateLadderDimensions(row, column);
    this.rows = new int[row][column];
    lines = new ArrayList<>();
}

private void validateLadderDimensions(int row, int column) {
    if(row < 2 || column < 2) {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_LADDER_SIZE.getMessage());
    }
}

public void addLine(int fromLine, int toLine, int currentRow) {
    Line line = new Line(fromLine, toLine, currentRow, this.rows);
    lines.add(line);
}

public boolean isLine(int row, int col) {
    return rows[row][col] == 1 || rows[row][col] == -1;
}

public boolean isLineAtLeft(int row, int col) {
    return col > 0 && rows[row][col - 1] == - 1;
}

public boolean isLineAtRight(int row, int col) {
    return col + 1  < rows[row].length && rows[row][col + 1] == 1;
}

public int getHeight() {
    return rows.length;
}

public int getWidth() {
    return rows[0].length;
}

public int getRows(int row, int col) {
    return rows[row][col];
}

    public boolean isLeftLine(int currentRow, int currentCol) {
        return rows[currentRow][currentCol] == 1;
    }

    public boolean isRightLine(int currentRow, int currentCol) {
        return rows[currentRow][currentCol] == - 1;
    }
}
