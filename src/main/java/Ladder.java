public class Ladder {
    // Ladder
    private final Matrix matrix; // should get Matrix's row and numberOfPerson
    // private LadderLine LadderLine = new LadderLine();

    public Ladder(Matrix matrix) {
        // 사다리 생성하고 크기 지정해야 함
        this.matrix = new Matrix(matrix.getRow(),matrix.getNumberOfPerson());
    }

    public static Ladder createLadder(NaturalNum row, NaturalNum numberOfPerson) {
        Ladder ladder = new Ladder(new Matrix(row, numberOfPerson));
        return new Ladder(new Matrix(row, numberOfPerson));
    }

    // Line is always drawn from left to right. (1을 먼저 대입하고 오른쪽에 -1 대입, 1 : 오른쪽이동 / -1 : 왼쪽이동)
    // 연속된 라인은 허용하지 않는다

    public void drawLine(LadderLine ladderLine) { // make LadderLine of ladder
        // checkList
        // If coordinate out of range(row / col(numberOfPerson)
        // If that point is last col Line (only can draw to right)
        // If that point has been drawn

        int direction = 1;
        // 이미 -1되이, 2차원 배열의 좌표 단위에 맞춰짐 (0부터 시작)
        int x = ladderLine.getX();
        int y = ladderLine.getY();

        if (! checkCoordinateRange(x,y)) { // if coordinate out of range
            throw new IllegalArgumentException("Out of coordinate range");
        }

        if (! checkColRange(x)) { // if that point is last col Line
            throw new IllegalArgumentException("At the end of X coordinate can't draw to right");
        }

        if (! checkDrawn(x,y)) { // If that point has been drawn
            throw new IllegalArgumentException("Point (x,y) has already been drawn");
        }

        // drawingLine
        matrix.setDirection(x,y, direction);
        matrix.printLadder();

    }

    // implement a movement along the line
    public int run(NaturalNum line) { // choose num of ladder then can know where line to arrive
        // check x coordinate is out of range

        if (!checkCoordinateRange(line.getNaturalNum()))
            throw new IllegalArgumentException("Out of starter line range");

        return matrix.runLadder(line);
    }

    // -----------------------------------------------------------------------------------------------------
    public int getRowsLength() {
        return matrix.getRowsLength();
    }

    public int getIntRow() {
        return matrix.getIntRow();
    }

    public int getIntNumberOfPerson() {
        return matrix.getIntNumberOfPerson();
    }

    public boolean checkCoordinateRange(int x, int y) {
        if ((y > matrix.getIntRow()-1) && (x > matrix.getIntNumberOfPerson()-1))
            return false;

        return true;
    }

    public boolean checkColRange(int x) {
        if (x > matrix.getIntNumberOfPerson() - 2)
            return false;

        return true;
    }

    public boolean checkDrawn(int x, int y) {
        if (matrix.returnMatrixValue(x,y) == 1 || matrix.returnMatrixValue(x,y) == -1) {
            return false;
        }
        return true;
    }

//    public int getMatrixValue(int x, int y) {
//        return matrix.returnMatrixValue(x,y);
//    }


    // run메소드 starter line 검사
    public boolean checkCoordinateRange(int x) {
        if ((x > matrix.getIntNumberOfPerson()-1))
            return false;

        return true;
    }

}

// 객체지향 생활 체조 원칙 9단계
// 1. 메소드 하나에는 하나의 들여쓰기만
// 2. else 지양 (if문 안에서 early return)
// 3. 원시값과 문자열을 wrapper 객체로
// 4. method 체이닝 X
// 5. 축약X
// 6. Entity 적게 유지 (짧게하기)
// 7. 인스턴스는 1개만
// 8. 일급 컬렉션
// 9. getter / setter / property를 쓰지 않는다