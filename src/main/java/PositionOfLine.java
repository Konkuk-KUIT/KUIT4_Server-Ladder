public class PositionOfLine {
    private int x;
    private int y;

    private PositionOfLine(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static PositionOfLine of(int x, int y) {
        return new PositionOfLine(x, y);
    }

    public void canDrawLine(int row_num, int col_num) {
        if (x < 0 || y < 0 || x >= row_num || y >= col_num) {
            throw new IllegalArgumentException("Can't draw a line in this position");
        }
    }

    public void makeLine(int[][] array) {
        array[x][y] = 1;
        array[x][y+1] = -1;
    }

    public boolean checkLine(int[][] array) {
        if ((array[x][y] == 1) && (array[x][y+1] == -1)) { return true; }
        return false;
    }
}
