import java.util.Scanner;

public class Game {
    private final Ladder ladder;
    private final Player player;

    public Game(int row, int numberOfPerson, int playerStartPosition) {
        this.ladder = new Ladder(row, numberOfPerson);
        this.player = new Player(playerStartPosition);
    }

    public void play(int numberOfLine) {
        try {
            ladder.drawLine(numberOfLine);

            // 사다리는 0부터 시작하기 때문에
            int result = ladder.run(player.getStartPosition())+1;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Program terminated due to an error: " + e.getMessage());
        }


    }

    public static void main(String[] args) {
        int row, numberOfPerson, numberOfLine;
        Scanner scanner = new Scanner(System.in);

        /*System.out.println("Enter the number of rows in the game: ");
        row=scanner.nextInt();

        System.out.println("Enter the number of persons in the game: ");
        numberOfPerson=scanner.nextInt();*/

        System.out.print("Input your start position (MAX 3): ");
        int startPosition = scanner.nextInt();

        System.out.print("Input your Number of Line (Max 5): ");
        numberOfLine = scanner.nextInt();

        // 사다리의 크기는 가로로 3, 세로로 5로 설정했습니다.
        Game game = new Game(5, 3, startPosition);
        game.play(numberOfLine);

        scanner.close();
    }
}