package ladder;

import ladder.creator.CustomLadderCreator;
import ladder.creator.LadderCreator;
import ladder.creator.RandomLadderCreator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    void 사다리_생성_확인() {
        //given
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(5);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);

        //when
        CustomLadderCreator customLadderCreator = CustomLadderCreator.from(ladderSize);

        //then
        assertThat(customLadderCreator).isNotNull();
    }

    @Test
    void 사다리_사람_예외_처리_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(2);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        CustomLadderCreator customLadderCreator = CustomLadderCreator.from(LadderSize.of(numberOfRow, numberOfPerson));
        LadderGame ladderGame = LadderGame.from(customLadderCreator);

        //given
        Position position = Position.from(4);

        //then
        assertThatThrownBy(() -> ladderGame.run(position))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리_결과_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createCustomLadderGame(ladderSize);

        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        ladderCreator.drawLine(LadderPosition.of(Position.from(0),Position.from(0)));
        ladderCreator.drawLine(LadderPosition.of(Position.from(1),Position.from(1)));
        ladderCreator.drawLine(LadderPosition.of(Position.from(2),Position.from(0)));

        //given
        Position position = Position.from(0);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(2);

        //given
        position = Position.from(1);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(1);

        //given
        position = Position.from(2);

        //then
        assertThat(ladderGame.run(position)).isEqualTo(0);
    }

    @Test
    void 랜덤_사다리_게임_생성_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        Position position = Position.from(0);

        //given
        LadderGame ladderGame1 = LadderGameFactory.createRandomLadderGame(ladderSize);
        ladderGame1.run(position);

        LadderGame ladderGame2 = LadderGameFactory.createRandomLadderGame(ladderSize);
        ladderGame2.run(position);

        //then
        assertThat(ladderGame1).isNotEqualTo(ladderGame2);
    }

    @Test
    void 랜덤_사다리_게임_결과_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(ladderSize);

        //given
        Position position = Position.from(0);
        int result0 = ladderGame.run(position);

        position = Position.from(1);
        int result1 = ladderGame.run(position);

        //then
        assertThat(result0).isNotEqualTo(result1);
    }

    @Test
    void 랜덤_사다리_생성_시_주위_노드_정상_여부_확인() {
        //when
        GreaterThanOne numberOfRow = GreaterThanOne.from(3);
        GreaterThanOne numberOfPerson = GreaterThanOne.from(3);
        LadderSize ladderSize = LadderSize.of(numberOfRow, numberOfPerson);
        RandomLadderCreator ladderCreator = RandomLadderCreator.emptyLadderFrom(ladderSize);
        LadderWrapper ladderWrapper = ladderCreator.getLadderWrapper();

        LadderPosition existPos1 = LadderPosition.of(Position.from(0), Position.from(0));
        ladderCreator.drawLine(existPos1);
        LadderPosition existPos2 = LadderPosition.of(Position.from(2), Position.from(1));
        ladderCreator.drawLine(existPos2);

        //given
        HashSet<LadderPosition> existHashSet = new HashSet<LadderPosition>(List.of(existPos1, existPos2));
        LadderPosition createdLadderPosition = ladderCreator.makeRandomLine(existHashSet);
        Position createdRowPosition = createdLadderPosition.getRowPos();
        Position createdColPosition = createdLadderPosition.getColPos();

        //then
        // 중간 열에 라인이 생성되는지 확인
        assertThat(createdLadderPosition.getRowPos().getValue()).isEqualTo(1);

        // createdLadderPosition의 ladder value 값이 1인지 확인
        assertThat(ladderCreator.getInLadderValue(createdLadderPosition)).isEqualTo(1);

        // createdLadderPosition 우측 노드의 ladder value 값이 -1인지 확인
        Position right1Position = createdColPosition.nextPosition();
        LadderPosition right1LadderPosition = LadderPosition.of(createdRowPosition, right1Position);
        assertThat(ladderCreator.getInLadderValue(right1LadderPosition)).isEqualTo(-1);

        // createdLadderPosition 2칸 우측 노드의 ladder value 값이 -1이 아닌지 확인
        if(right1Position.getValue() < ladderWrapper.getColsSize() - 1){
            Position right2Position = right1Position.nextPosition();
            LadderPosition right2LadderPosition = LadderPosition.of(createdRowPosition, right2Position);
            assertThat(ladderCreator.getInLadderValue(right2LadderPosition)).isNotEqualTo(-1);
        }

        // createdLadderPosition 좌측 노드의 ladder value 값이 1이 아닌지 확인
        if(createdColPosition.getValue() > 0) {
            Position left1Position = createdColPosition.prevPosition();
            LadderPosition left1LadderPosition = LadderPosition.of(createdRowPosition, left1Position);
            assertThat(ladderCreator.getInLadderValue(left1LadderPosition)).isNotEqualTo(1);
        }
    }
}