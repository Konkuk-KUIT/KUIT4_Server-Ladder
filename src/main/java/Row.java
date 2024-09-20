public class Row {

    private final int row;

    private Row(int row) {
        if(row < 1) {
            throw new IllegalArgumentException("행은 1 이상이어야합니다.");
        }
        this.row = row;
    }

    public static Row from(int row) {
        return new Row(row);
    }

    public int getRow() {
        return row;
    }
}
