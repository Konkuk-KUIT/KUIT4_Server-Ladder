import java.util.Random;

public class PositionOfLine {
    private Index x;
    private Index y;

    private PositionOfLine(Index x, Index y) {
        this.x = x;
        this.y = y;
    }

    public static PositionOfLine of(Index x, Index y) {
        return new PositionOfLine(x, y);
    }

    public static PositionOfLine randomPosition(Index rowsNum, Index colsNum) {
        Random rand = new Random();
        Index x = Index.from(rand.nextInt(rowsNum.getNumber()));
        Index y = Index.from(rand.nextInt(colsNum.getNumber()));

        return PositionOfLine.of(x, y);
    }

    public Index getX() {
        return x;
    }

    public Index getY() {
        return y;
    }





}


//데이터를 감싸는 객체는 세터 게터가 불가피