package ladder;

public class Ladder {

    private final Row[] rows;

    public Ladder(int numberOfRow, int numberOfPerson) {
        rows = new Row[numberOfRow];
        for (int i = 0; i < numberOfRow; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public int run(int position) {
        for (int i = 0; i < rows.length; i++) {
            position = rows[i].nextPosition(position);
        }
        return position;
    }
}
