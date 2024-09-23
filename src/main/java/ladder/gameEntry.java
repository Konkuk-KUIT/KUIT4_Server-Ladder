package ladder;

public class gameEntry {
    unsignedInteger row;
    unsignedInteger column;

    private gameEntry(unsignedInteger row, unsignedInteger column) {
        this.row = row;
        this.column = column;
    }

    public static gameEntry from(int row, int column) {
        return new gameEntry(unsignedInteger.from(row), unsignedInteger.from(column));
    }

    public int getRow(){
        return row.getValue();
    }

    public int getColumn(){
        return column.getValue();
    }
}
