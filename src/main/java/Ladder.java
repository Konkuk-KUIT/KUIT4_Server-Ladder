public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    // 라인 생성하기 > 무조건 오른쪽 방향으로 생성
    public void drawLine(int row, int ladderIndex) {
        rows[row][ladderIndex] = 5;
        rows[row][ladderIndex+1] = 5;
    }

    // 오른쪽 방향으로 라인을 생성할 수 있는지 검사
    public int validDrawLine(int row) {
        if(row>=rows.length){
            System.out.println("Invalid draw line");
            return -1;
        }
        return row;
    }

    public int[][] getRows() {
        return rows;
    }
}
