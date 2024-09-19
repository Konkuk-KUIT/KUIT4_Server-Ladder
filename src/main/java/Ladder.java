public class Ladder {

    private final int[][] rows;

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
    }

    // 선택한 사다리 번호 검사
    public int validLadderIndex(int ladderIndex) {

        if (ladderIndex < 0 || ladderIndex >= rows.length) {
            System.out.println("Invalid ladder index");
            return -1;
        }

        return ladderIndex;
    }

    // 사다리 타고 올라가기
    public int run(int ladderIndex) {

        int Pi = 0;
        int Pj = ladderIndex;

        for (int k = 1; k < rows.length; k++) {
            Pi += 1;
            Pj = runSide(Pi, Pj);
        }
        return Pj;
    }

    // 생성된 라인에 도착하면 건너가기
    public int runSide(int row, int ladderIndex){
        if(rows[row][ladderIndex] == 5 && rows[row][ladderIndex+1] == 5){
            return ladderIndex+1;
        }
        if(rows[row][ladderIndex] == 5 && rows[row][ladderIndex-1] == 5){
            return ladderIndex-1;
        }
        return ladderIndex;
    }

    // 라인 생성하기 > 무조건 오른쪽 방향으로 생성
    public void drawLine(int i, int j) {
        rows[i][j] = 5;
        rows[i][j+1] = 5;
    }

    // 오른쪽 방향으로 라인을 생성할 수 있는지 검사
    public int validDrawLine(int i) {
        if(i>=rows.length){
            System.out.println("Invalid draw line");
            return -1;
        }
        return i;
    }
}
