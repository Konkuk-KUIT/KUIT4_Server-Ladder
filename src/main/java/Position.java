public class Position {


    private final int x;
    private final int y;

    public Position(Row row, Col col) {
        this.x = row.getRow() - 1;
        this.y = col.getCol() - 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
