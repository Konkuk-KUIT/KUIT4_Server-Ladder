public class LadderCreator {
    private Row[] rows;

    public LadderCreator(Index rowNum, Index numberOfPerson) {
        rows = new Row[rowNum.getNumber()];
        SetRows(numberOfPerson);
    }

    private void SetRows(Index numberOfPerson) {
        for (int i=0; i < rows.length; i++) {
            rows[i] = new Row(numberOfPerson);
        }
    }

    public void drawLine(PositionOfLine position) {
        canDrawLine(position);
        Index x = position.getX();
        Index y = position.getY();

        rows[x.getNumber()].setValue(y, Direction.RIGHT);
        rows[x.getNumber()].setValue(y, Direction.LEFT);
    }

    public void canDrawLine(PositionOfLine position) {
        Index x = position.getX();
        Index y = position.getY();
        
        if (LineAlreadyExisting(x, y) || validateRangeOfIndex(x, y)) {
            throw new IllegalArgumentException("Can't draw a line in this position");
        }
    }

    private boolean LineAlreadyExisting(Index x, Index y) {
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
