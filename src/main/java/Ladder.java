
public class Ladder {
    // 저장되는 값은 j방향으로 이동해야되는 정도
    private final int[][] rows;

    public Ladder(NaturalNumber row, NaturalNumber numberOfPerson) {
        rows = new int[row.getNaturalNumber()+1][numberOfPerson.getNaturalNumber()+1];
    }

    /*
    * 연속 사다리는 존재하지 않고, 만약에 1과 3을 잇는 사다리가 존재하면 1과 3에서만 이동할수 있는 '통로'가 있다고 가정합니다.
    * */
    public int drawLine(Position pos1 , Position pos2) {
        if(pos1.getRow() != pos2.getRow()) {
            throw new IllegalArgumentException("Positions do not match");
        }
        int row = pos1.getRow();
        int distance = pos2.getCol() - pos1.getCol();
        rows[row][pos1.getCol()] = distance;
        rows[row][pos2.getCol()] = -1 * distance;
        return 1;
    }

    public int run(NaturalNumber i) {
        int currentCol = i.getNaturalNumber();
        if (currentCol > this.rows[0].length) {
            throw new IllegalArgumentException("Column out of bounds");
        }
        for (int j = 1; j < rows.length; j++) {
            currentCol += rows[j][currentCol];
        }
        return currentCol;
    }

    public int getDistance(Position position) {
        return rows[position.getRow()][position.getCol()];
    }
}
