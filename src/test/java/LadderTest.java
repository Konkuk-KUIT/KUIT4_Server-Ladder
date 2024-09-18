import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("사다리생성")
    void CreateLadder() {
        Ladder ladder = new Ladder(1,3);
        assertThat(ladder).isNotNull();
    }

    @Test
    @DisplayName("사다리오른쪽라인생성")
    void CreateLadderLineRight(){
        Ladder ladder = new Ladder(4,4);
        ladder.drawLine(new Position(2,0),1);

        assertThat(ladder.getRows()[2][0]).isEqualTo(1);
        assertThat(ladder.getRows()[2][1]).isEqualTo(-1);
    }

    @Test
    @DisplayName("사다리맨마지막오른쪽예외")
    void CreateLadderLineRightExp(){
        Ladder ladder = new Ladder(4,4);

        assertThatThrownBy(()->ladder.drawLine(new Position(1,3),1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리왼쪽라인생성")
    void CreateLadderLineLeft(){
        Ladder ladder = new Ladder(4,4);
        ladder.drawLine(new Position(1,2),-1);

        assertThat(ladder.getRows()[1][2]).isEqualTo(-1);
        assertThat(ladder.getRows()[1][1]).isEqualTo(1);
    }

    @Test
    @DisplayName("사다리맨처음왼쪽예외")
    void CreateLadderLineLeftExp(){
        Ladder ladder = new Ladder(4,4);

        assertThatThrownBy(()->ladder.drawLine(new Position(1,0),-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리이동")
    void LadderMove(){
        Ladder ladder = new Ladder(4,4);
        ladder.drawLine(new Position(0,0),1);
        ladder.drawLine(new Position(0,2),1);
        ladder.drawLine(new Position(1,0),1);
        ladder.drawLine(new Position(2,1),1);
        ladder.drawLine(new Position(3,2),1);

        assertThat( ladder.run(1)).isEqualTo(3);

    }

    @Test
    @DisplayName("오른쪽연속적인사다리이동")
    void LadderMoveContinuousRight(){
        Ladder ladder = new Ladder(4,4);
        ladder.drawLine(new Position(0,0),1);
        ladder.drawLine(new Position(0,1),1);
        ladder.drawLine(new Position(0,2),1);
        ladder.drawLine(new Position(1,0),1);
        ladder.drawLine(new Position(2,1),1);
        ladder.drawLine(new Position(3,2),1);

        assertThat( ladder.run(0)).isEqualTo(2);

    }

    @Test
    @DisplayName("왼쪽연속적인사다리이동")
    void LadderMoveContinuousLeft(){
        Ladder ladder = new Ladder(4,4);
        ladder.drawLine(new Position(0,0),1);
        ladder.drawLine(new Position(0,1),1);
        ladder.drawLine(new Position(2,1),1);
        ladder.drawLine(new Position(2,0),1);

        assertThat(ladder.run(0)).isEqualTo(0);

    }

    //사다리왼쪽 라인생성//포지션 값예외터지는거//저기즉 ㅁ테스트에 값을 두개나확인하는데....그거좀 리팩토링
    //칼럼이 0 일때 칼럼이 마지막일때 //글고 이제 이동구현// 커밋한다음에 //리팩토링하기
    //리팩터링 캡슐화헤서 겟인스턴스함수로만들어서 생성자에서 바로못만들게 좀바꾸고 디렉션?도 클래스로
    //만들어야할지도?

}