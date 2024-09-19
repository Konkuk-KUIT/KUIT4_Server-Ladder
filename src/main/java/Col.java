public class Col {

    private final int col;

    private Col(int col) {
        if (col < 1) {
            throw new IllegalArgumentException("열은 1 이상이어야합니다.");
        }

        this.col = col;
    }

    public static Col from(int col) {
        return new Col(col);
    }

    public int getCol() {
        return col;
    }
}
