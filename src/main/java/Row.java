public class Row {

    private int[] row;

    public Row(int ladderNum){
        row = new int[ladderNum];
    }

    public void checkLinePossible(int pos){
        // 유효범위 1~사다리 개수
        if(pos<0 || pos>row.length-1){
            throw new IllegalArgumentException("Invalidate Position");
        }
        // 라인의 길이 -> 1
        if(row[pos] == -1 || row[pos + 1] == 1){
            throw new IllegalArgumentException("Invalidate Position");
        }
    }

    public void drawLine(int pos) {
        checkLinePossible(pos);
        row[pos] = 1;
        row[pos + 1] = -1;
    }

    public int movePos(int pos){
        if(pos == 1)
            return pos+1;
        if(pos == -1)
            return pos-1;
        return pos;
    }
}
