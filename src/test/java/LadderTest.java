import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리객체_테스트() {
        // 사다리 객체가 정상적으로 생성되는지 테스트
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(4));
        assertNotNull(ladder);
    }

    @Test
    void testDrawLine() {
        // 선을 정상적으로 그릴 수 있는지, 같은 위치에 중복으로 선을 그릴 수 없는지 테스트
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(4));
        assertDoesNotThrow(() -> ladder.drawLine(0, 0));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 0));
    }

    @Test
    void testDrawLine_OutOfBounds() {
        // 사다리의 범위를 벗어나는 위치에 선을 그리려 할 때 예외가 발생하는지 테스트
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(4));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(5, 0));
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 3));
    }

    @Test
    void 간단한_사다리테스트() {
        // 사다리 게임을 실행했을 때 예상한 결과가 나오는지 테스트
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(4));
        ladder.drawLine(0, 0);
        ladder.drawLine(1, 1);
        ladder.drawLine(2, 2);

        assertEquals(4, ladder.run(1));
        assertEquals(1, ladder.run(2));
        assertEquals(2, ladder.run(3));
        assertEquals(3, ladder.run(4));
    }

    @Test
    void 복잡한_사다리테스트() {
        //더 복잡한 테스트
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(6));
        ladder.drawLine(0, 0);
        ladder.drawLine(0, 2);
        ladder.drawLine(0, 4);
        ladder.drawLine(1, 1);
        ladder.drawLine(1, 3);
        ladder.drawLine(2, 0);
        ladder.drawLine(2, 2);
        ladder.drawLine(2, 4);
        ladder.drawLine(3, 1);
        ladder.drawLine(3, 3);
        ladder.drawLine(4, 0);
        ladder.drawLine(4, 2);
        ladder.drawLine(4, 4);

        assertEquals(6, ladder.run(1));
        assertEquals(4, ladder.run(2));
        assertEquals(5, ladder.run(3));
        assertEquals(2, ladder.run(4));
        assertEquals(3, ladder.run(5));
        assertEquals(1, ladder.run(6));
    }

    @Test
    void 시작_위치_테스트() {
        // 유효하지 않은 시작 위치로 게임을 실행하려 할 때 예외가 발생하는지 테스트
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(4));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(0));
        assertThrows(IllegalArgumentException.class, () -> ladder.run(5));
    }

    @Test
    void 가로선_연속_테스트() {
        // 연속된 가로선을 그리려 할 때 예외가 발생하는지 테스트
        Ladder ladder = new Ladder(NaturalNumber.from(5), NaturalNumber.from(4));
        ladder.drawLine(0, 0);
        assertThrows(IllegalArgumentException.class, () -> ladder.drawLine(0, 1));
    }

    @Test
    void testNaturalNumber() {
        // NaturalNumber 클래스가 올바르게 동작하는지 테스트
        assertDoesNotThrow(() -> NaturalNumber.from(1));
        assertThrows(IllegalArgumentException.class, () -> NaturalNumber.from(0));
        assertThrows(IllegalArgumentException.class, () -> NaturalNumber.from(-1));
    }
}