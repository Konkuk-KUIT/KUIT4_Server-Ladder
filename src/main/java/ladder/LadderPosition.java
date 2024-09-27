package ladder;

// 사다리 출력을 위해, (x,y)좌표를 동시에 다루는 클래스
// 어디에 점을 찍을 지 알 수 있다...?
public class LadderPosition {
    Position x, y;

    public LadderPosition(Position x, Position y) {
        this.x = x;
        this.y = y;
    }

    public Position getX() {
        return x;
    }

    public Position getY() {
        return y;
    }

    public int getIntX() {
        return x.getPosition();
    }

    public int getIntY() {
        return y.getPosition();
    }


}
