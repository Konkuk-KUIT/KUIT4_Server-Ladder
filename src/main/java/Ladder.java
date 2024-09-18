public class Ladder {

    private final int[][] rows;

    public int[][] getRows() {
        return rows;
    }

    private Ladder(int row, int numberOfPerson) {
        this.rows = new int[row][numberOfPerson];
    }

    public static Ladder creatLadder(int row, int numberOfPerson) {
        Ladder ladder =new Ladder(row,numberOfPerson);
        ladder.resetLine(row, numberOfPerson);
        return ladder;
    }

    //사다리 초기화
    public void resetLine(int row, int numberOfPerson){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < numberOfPerson; j++) {
                rows[i][j] = 0;
            }
        }
    }

    //사다리 라인 생성
    public void drawLine(Position position,Direction direction){

        int row = position.getRow();
        int col = position.getCol();

        //잘못된 위치값에 대한 예외
        //이예외를 Ladder내에서 터트려야할지? Position 객체 내에서 터트려야할지?
        if (row >= rows.length || col >= rows[row].length) {
            throw new IllegalArgumentException("잘못된 위치입니다. 사다리 높이 내에서 위치를 지정하세요.");
        }

        //오른쪽으로 라인 생성
        if (direction == Direction.RIGHT) {
            if(col == rows[row].length-1)
                throw new IllegalArgumentException("오른쪽에 선을 그을수 없습니다.");
            rows[row][col] = 1;
            rows[row][col + 1] = -1;
        }
        //왼쪽으로 라인 생성
        if (direction == Direction.LEFT){
            if(col == 0)
                throw new IllegalArgumentException("왼쪽에 선을 그을수 없습니다.");
            rows[row][col] = -1;
            rows[row][col-1] = 1;
        }

    }


    public int run(int selectLineNum){

        int arriveLineNum = selectLineNum;

        for (int i = 0; i < rows.length; i++) {
            // 현재 위치가 유효한지 확인
            if (arriveLineNum < 0 || arriveLineNum >= rows[i].length) {
                break; // 범위를 벗어난 경우 종료
            }

            // 오른쪽으로 이동
            if(rows[i][arriveLineNum] == 1) {
                arriveLineNum++;
                //연속으로 오른쪽으로 이동하는 경우
                while (arriveLineNum < rows[i].length -1 && rows[i][arriveLineNum] == 1) {
                    arriveLineNum++; // 오른쪽으로 계속 이동
                }
                System.out.println(arriveLineNum);
            }
            // 왼쪽으로 이동
            else if (rows[i][arriveLineNum] == -1) {
                arriveLineNum--;
                // 연속해서 왼쪽으로 이동하는 경우
                while (arriveLineNum > 0 && rows[i][arriveLineNum] == -1) {
                    arriveLineNum--; // 왼쪽으로 계속 이동
                }
            }
            // 선이 없을 경우
            else if (rows[i][arriveLineNum] == 0) {
                continue; // 선이 없는 경우 다음 행으로 이동
            }
        }

        return arriveLineNum;
    }


}