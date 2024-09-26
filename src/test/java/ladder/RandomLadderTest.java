package ladder;

import ladder.creator.LadderAutoCreator;
import ladder.creator.LadderCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomLadderTest {
    GreaterThanOne numberOfPerson;
    GreaterThanOne row;

    @BeforeEach
    void setUp() {
        numberOfPerson = GreaterThanOne.from(4);
        row = GreaterThanOne.from(3);
    }


    @Test
    void 사다리_자동_생성_결과_확인(){
        //given

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(numberOfPerson,row);
        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        ladderCreator.drawLine(Position.from(0),Position.from(0));


        //when
        ladderGame.run(Position.from(0));

    }
    
    @Test
    void 사다리_일반_생성_결과_확인(){
        //given

        LadderGame ladderGame = LadderGameFactory.createLadderGame(numberOfPerson,row);
        LadderCreator ladderCreator = ladderGame.getLadderCreator();
        ladderCreator.drawLine(Position.from(0),Position.from(0));

        //when
        ladderGame.run(Position.from(0));
    }

}
