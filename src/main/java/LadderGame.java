import java.util.Scanner;

public class LadderGame {
    private Ladder ladder;
    private static Scanner scanner;
    private int startPosition;
    private LadderRunner ladderRunner;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public void play() {
        System.out.print("Enter the start position: ");
        startPosition = scanner.nextInt();

        ladderRunner = new LadderRunner(ladder, startPosition);
        int result = ladderRunner.run()+1;
        System.out.println("Final position: " + result);
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        LadderGame game = LadderGameFactory.createRandomLadderGame(5, 5);
        game.play();
        scanner.close();
    }
}
