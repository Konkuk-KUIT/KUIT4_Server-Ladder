public class RunLadder {

    private Ladder ladder;

    public RunLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    // 선택한 사다리 번호 검사
    public int validLadderIndex(int ladderIndex) {

        int[][] rows = ladder.getRows();

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
        int[][] rows = ladder.getRows();

        for (int k = 1; k < rows.length; k++) {
            Pi += 1;
            Pj = moveAccross(rows, Pi, Pj);
        }
        return Pj;
    }

    // 생성된 라인에 도착하면 건너가기
    public int moveAccross(int [][] rows, int row, int ladderIndex){
        if(rows[row][ladderIndex] == 5 && rows[row][ladderIndex+1] == 5){
            return ladderIndex+1;
        }
        if(rows[row][ladderIndex] == 5 && rows[row][ladderIndex-1] == 5){
            return ladderIndex-1;
        }
        return ladderIndex;
    }
}
