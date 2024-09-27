import java.util.Random;

public class LadderCreator {
    private Row[] rows;

    public LadderCreator(Index rowNum, Index numberOfPerson, boolean isRandom) {
        rows = new Row[rowNum.getNumber()];
        SetRows(numberOfPerson);
        if (isRandom) {
            MakeRandomLine(numberOfPerson);
        }
    }

    private void SetRows(Index numberOfPerson) {
        for (int i=0; i < rows.length; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    private void MakeRandomLine(Index numberOfPerson) {
        int numberOfLines = (int) (rows.length * numberOfPerson.getNumber() * 0.3);
        Index rowsLength = Index.from(rows.length);

        for (int i=0; i < numberOfLines; i++) {
            PositionOfLine position = PositionOfLine.randomPosition(rowsLength, numberOfPerson);
            PositionOfLine nextPosition = PositionOfLine.of(position.getX(), position.getY().nextIndex());

            if (canDrawLine(position) && !LineAlreadyExisting(position.getX(), position.getY().nextIndex())) { drawLine(position); continue;}
            i--;
        }
    }

    public void drawLine(PositionOfLine position) {
        canDrawLine(position);
        Index x = position.getX();
        Index y = position.getY();

        rows[x.getNumber()].setValue(y, Direction.RIGHT);
        rows[x.getNumber()].setValue(y.nextIndex(), Direction.LEFT);
    }

    public boolean canDrawLine(PositionOfLine position) {
        Index x = position.getX();
        Index y = position.getY();
        
        if (LineAlreadyExisting(x, y) || validateRangeOfIndex(x, y)) {
            return false;
        }

        return true;
    }

    public boolean LineAlreadyExisting(Index x, Index y) {
        Node node = rows[x.getNumber()].getValue(y);
        return node.isLeft() || node.isRight();
    }

    private boolean validateRangeOfIndex(Index x, Index y) {
        return x.getNumber() >= rows.length || y.getNumber() >= rows[0].getPeopleNum() - 1;
    }

    public Row[] getRow() {
        return rows;
    }
}
