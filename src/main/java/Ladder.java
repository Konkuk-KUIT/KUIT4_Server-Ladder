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
        return ladder;
    }

    //사다리 라인 생성
    public void drawLine(Position position,Direction direction){

        int row = position.getRow();
        int col = position.getCol();

        //잘못된 위치값에 대한 예외
        if (row >= rows.length || col >= rows[row].length) {
            throw new IllegalArgumentException("잘못된 위치입니다. 사다리 높이 내에서 위치를 지정하세요.");
        }

        //오른쪽으로 라인 생성
        if (direction == Direction.RIGHT) {
            drawLineEndExp(row,col,direction);
            rows[row][col] = 1;
            rows[row][col + 1] = -1;
        }
        //왼쪽으로 라인 생성
        if (direction == Direction.LEFT){
            drawLineEndExp(row,col,direction);
            rows[row][col] = -1;
            rows[row][col-1] = 1;
        }

    }

    //맨 왼쪽, 오른쪽 유효성 검증
    public void drawLineEndExp(int row,int col,Direction direction){
        if(col == rows[row].length-1 && direction == Direction.RIGHT)
            throw new IllegalArgumentException("오른쪽에 선을 그을수 없습니다.");
        if(col == 0 && direction == Direction.LEFT)
            throw new IllegalArgumentException("왼쪽에 선을 그을수 없습니다.");
    }


    public int run(int selectLineNum){

        int arriveLineNum = selectLineNum;

        for (int i = 0; i < rows.length; i++) {

            // 오른쪽으로 이동
            if(rows[i][arriveLineNum] == 1) {
                arriveLineNum++;
                //연속으로 오른쪽으로 이동하는 경우
                while (arriveLineNum < rows[i].length -1 && rows[i][arriveLineNum] == 1) {
                    arriveLineNum++; // 오른쪽으로 계속 이동
                }
            }
            // 왼쪽으로 이동
            else if (rows[i][arriveLineNum] == -1) {
                arriveLineNum--;
                // 연속해서 왼쪽으로 이동하는 경우
                while (arriveLineNum > 0 && rows[i][arriveLineNum] == -1) {
                    arriveLineNum--; // 왼쪽으로 계속 이동
                }
            }
        }

        return arriveLineNum;
    }


}