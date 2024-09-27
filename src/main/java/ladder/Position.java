package ladder;

import java.util.Objects;

import static ladder.exception.ExceptionMessage.INVALID_LADDER_POSITION;

public class Position {

    private int row;
    private int col;


    private Position(int row,int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public static Position of(int row, int col) {
        validatePosition(row, col);
        return new Position(row,col);
    }


    public void prev() {
       col--;
    }

    public void next() {
        col++;
    }

    public boolean isSmallerThan(int col) {
        return this.col < col;
    }

    public boolean isBiggerThan(int col) { return this.col > col; }

    public boolean isCurrentPosition(int row, int col) {
        return this.row == row && this.col == col;
    }


    private static void validatePosition(int row, int col) {
        if (!isPosition(row, col)) {
            throw new IllegalArgumentException(INVALID_LADDER_POSITION.getMessage());
        }
    }

    private static boolean isPosition(int row, int col) {
        return row >= 0 && col>=0 ;
    }

    public void UpdateRow() {
        (this.row)++;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
