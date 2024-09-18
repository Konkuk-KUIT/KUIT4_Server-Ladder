public class Ladder {

    private final int[][] rows;

    public int[][] getRows() {
        return rows;
    }

    public Ladder(int row, int numberOfPerson) {
        rows = new int[row][numberOfPerson];
        resetLine(row, numberOfPerson);
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
    public void drawLine(Position position,int direction){

        int row = position.getRow();
        int col = position.getCol();

        //잘못된 위치값에 대한 예외
        //이예외를 Ladder내에서 터트려야할지? Position 객체 내에서 터트려야할지?
        if (row >= rows.length || col >= rows[row].length) {
            throw new IllegalArgumentException("잘못된 위치입니다. 사다리 높이 내에서 위치를 지정하세요.");
        }

        //direction -1 왼쪽 +1 오른쪽
        //오른쪽으로 라인 생성
        if(direction == 1) {
            if(col == rows[row].length-1)
                throw new IllegalArgumentException("오른쪽에 선을 그을수 없습니다.");
            rows[row][col] = 1;
            rows[row][col + 1] = -1;
        }
        //왼쪽으로 라인 생성
        if(direction == -1){
            if(col == 0)
                throw new IllegalArgumentException("왼쪽에 선을 그을수 없습니다.");
            rows[row][col] = -1;
            rows[row][col-1] = 1;
        }

    }


    public int run(int selectLineNum){

        int arriveLineNum = selectLineNum;

//        for(int i = 0; i < rows.length; i++){
//
//            for(int j = arriveLineNum; j < rows[i].length; j++){
//
//                //연속해서 선이 그어져있을 경우 무조건 오른쪽으로 가도록
//                if(rows[i][j] == 1){
//                    arriveLineNum= j+1;
//                    //연속으로 안그어져있을 경우에만 반복문 빠져나가기
//                    if (arriveLineNum< rows[i].length && rows[i][arriveLineNum] != 1)
//                        break;
//                }
//                if(rows[i][j] == -1){
//                    arriveLineNum= j-1; //왼쪽이동
//                    if (arriveLineNum > 0 && rows[i][arriveLineNum] != -1)
//                        break;
//                }
//                if(rows[i][j] == 0){
//                    break; //선없을경우 다음row로 이동하기
//                }
//            }
//        }

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
//
//
//
//    public void display() {
//        for (int[] row : rows) {
//            for (int cell : row) {
//                System.out.print((cell == 1 ? "-" : " ") + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void main(String[] args) {
//        Ladder ladder = new Ladder(3, 5);
//        ladder.drawLine(0); // 첫 번째 라인 추가
//        ladder.drawLine(1); // 두 번째 라인 추가
//        ladder.display();    // 사다리 출력
//    }

}