import ladder.Player;
import ladder.Row;
import ladder.constants.Direction;
import ladder.wrapper.ArrayIndex;
import ladder.wrapper.unsignedInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("정적 팩토리 메소드가 player 객체를 반환하는지 확인")
    void Player_create_test() {
        //when
        ArrayIndex currentLadderIndex = ArrayIndex.of(2);

        //given
        Player player = Player.startingFrom(currentLadderIndex);

        //then
        assertThat(player).isNotNull().isInstanceOf(Player.class);
    }

    @Test
    @DisplayName("moveIfThereIsLineIn이 정상 작동되는지 확인")
    void Player_move_test(){
        //when
        ArrayIndex currentLadderIndex = ArrayIndex.of(2);
        Player player = Player.startingFrom(currentLadderIndex);
        Row row = new Row(5);
        row.drawLineAt(unsignedInt.from(2), Direction.RIGHT);

        //given
        player.moveIfThereIsLineIn(row);

        //then
        assertThat(player.getCurrentLadderIndex()).isEqualTo(ArrayIndex.of(2).getIndex() + 1);
    }

}
