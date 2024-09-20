public class Ladder {
    // 따로 verify 함수 생성

    private final Row[] rows;

    public Ladder(int row, int ladderNum) {
        rows = new Row[row];
        for (int i = 0; i < row; i++) {
            rows[i] = new Row(ladderNum);
        }
    }
    public void drawLine(int row, int col) {
        rows[row].drawLine(col);
    }

    public int run(int pos){
        // position에 따라 계속 movePos 옮기면서 row가 사다리 높이가 될때까지
        for (int i = 0; i < rows.length; i++) {
            pos = rows[i].movePos(pos);
        }
        return pos;
    }
}
