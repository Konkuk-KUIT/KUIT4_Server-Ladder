package ladder;

import ladder.creator.DefaultLadderCreator;
import ladder.creator.RandomLadderCreator;

public class Main {
    public static void main(String[] args) {
        // row and col
        GreaterThanOne numberOfPerson = GreaterThanOne.from(4);
        GreaterThanOne row = GreaterThanOne.from(3);


        // 기본 사다리 게임
        System.out.println("기본 사다리게임 시작 : ");
        DefaultLadderCreator defaultLadderCreator = new DefaultLadderCreator(row, numberOfPerson);
        LadderGame defaultLadderGame = new LadderGame(defaultLadderCreator);

        defaultLadderCreator.drawLine(Position.from(0),Position.from(0));
        defaultLadderCreator.drawLine(Position.from(1),Position.from(1));
        defaultLadderCreator.drawLine(Position.from(2),Position.from(0));

        defaultLadderGame.run(Position.from(0));
        System.out.println();
        // 기본 사다리 게임 출력 끝

        // 랜덤 사다리 게임 시작
        System.out.println("랜덤 사다리 게임 시작 : ");
        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(row, numberOfPerson);
        LadderGame randomLadderGame = new LadderGame(randomLadderCreator);
        randomLadderCreator.drawRandomLines();
        randomLadderGame.run(Position.from(0));
        System.out.println("왜이러지..");

    }
}
