// Used when we drawLine, to control coordinate
// 일단 만들어야 할 거같아서 만듦

// Q : 좌표를 받아서 범위 유효성 검사를 이 클래스에서 진행하면 좋을 것 같은데 Ladder클래스의 멤버에 접근을...
public class LadderLine {
    private int x, y;

    private LadderLine(NaturalNum x) {
        this.x = x.getNaturalNum() - 1;
    }

    private LadderLine(NaturalNum x, NaturalNum y) {
        this.x = x.getNaturalNum() - 1;
        this.y = y.getNaturalNum() - 1;
        // x, y의 유효성 검사를 이 클래스에서 해야 할 거 같은데 row와 numberofPerson에 접근을 못해서 여기에 만듦

    }

    public static LadderLine from(NaturalNum x,NaturalNum y) {
        return new LadderLine(x,y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
