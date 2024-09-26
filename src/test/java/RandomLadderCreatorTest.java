import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLadderCreatorTest {

    @Test
    @DisplayName("사다리의 크기가 올바르게 생성되는지 확인")
    void testCreateLineWithCorrectSize() {
        RandomLadderCreator creator = new RandomLadderCreator();
        Ladder ladder = creator.createLine(5, 3);

        Assertions.assertEquals(5, ladder.getHeight());
        Assertions.assertEquals(3, ladder.getWidth());
    }

    @Test
    @DisplayName("라인이 위치에 추가되는지 확인")
    void testCanAddLineAtValidPosition() {

        // Given
        RandomLadderCreator creator = new RandomLadderCreator();
        Ladder ladder = new Ladder(5, 3);

        // When
        boolean canAddLineAt00 = creator.canAddLine(ladder, 0, 0);
        boolean canAddLineAt21 = creator.canAddLine(ladder, 2, 1);

        // Then
        Assertions.assertTrue(canAddLineAt00);
        Assertions.assertTrue(canAddLineAt21);

    }

    @Test
    @DisplayName("이미 라인이 있는 위치에는 라인을 추가할 수 없는지 확인")
    void testCannotAddLineAtOccupiedPosition() {

        // Given
        RandomLadderCreator creator = new RandomLadderCreator();
        Ladder ladder = new Ladder(5, 3);
        ladder.addLine(0, 1, 0);

        // When
        boolean canAddLineAt00 = creator.canAddLine(ladder, 0, 0);

        // Then
        Assertions.assertFalse(canAddLineAt00);
    }

    @Test
    @DisplayName("마지막 행에는 라인을 추가할 수 없는지 확인")
    void testCannotAddLineAtLastRow() {

        // Given
        RandomLadderCreator creator = new RandomLadderCreator();
        Ladder ladder = new Ladder(5, 3);

        // When
        boolean canAddLineAt41 = creator.canAddLine(ladder, 4, 1);

        // Then
        Assertions.assertFalse(canAddLineAt41);
    }

    @Test
    @DisplayName("이미 오른쪽에 라인이 있는 위치에는 라인을 추가할 수 없는지 확인")
    void testCannotAddLineAtAlreadyRight() {

        //Given
        RandomLadderCreator creator = new RandomLadderCreator();
        Ladder ladder = new Ladder(5, 3);
        ladder.addLine(1, 2, 0);

        // When
        boolean canAddLineAt00 = creator.canAddLine(ladder, 0, 0);

        // Then
        Assertions.assertFalse(canAddLineAt00);
    }

    @Test
    @DisplayName("이미 왼쪽에 라인이 있는 위치에는 라인을 추가할 수 없는지 확인")
    void testCannotAddLineAtAlreadyLeft() {

        //Given
        RandomLadderCreator creator = new RandomLadderCreator();
        Ladder ladder = new Ladder(5, 3);
        ladder.addLine(0, 1, 0);

        // When
        boolean canAddLineAt00 = creator.canAddLine(ladder, 0, 1);

        // Then
        Assertions.assertFalse(canAddLineAt00);
    }

}