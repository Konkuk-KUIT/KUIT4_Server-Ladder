package ladder;

public class Main {
    public static void main(String[] args) {

        LadderGame ladderGame = LadderGameFactory.createRandomLadderGame(4, 5);
        Position startPosition = Position.from(0);

        System.out.println("사다리 게임 시작");
        ladderGame.run(startPosition);
    }
}
