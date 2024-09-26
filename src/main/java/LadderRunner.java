public class LadderRunner {

    private final Ladder ladder;
    private Player player;

    public LadderRunner(Ladder ladder, int startPosition) {
        this.ladder = ladder;
        this.player = new Player(startPosition);
    }

    int run() {
        while (true) {
            printLadderState("Before");

            // 오른쪽으로 가기
            if (ladder.isLeftLine(player.getyPosition(), player.getxPosition())) {
                player.right();
                printLadderState("After");
                player.down();
            }
            // 왼쪽으로 가기
            else if (ladder.isRightLine(player.getyPosition(), player.getxPosition())) {
                player.left();
                printLadderState("After");
                player.down();
            }
            // 그냥 아래로 가기
            else {
                player.down();
                if (isGameOver()) {
                    printLadderState("Final");
                    break;
                }
                printLadderState("After");
            }

            if (isGameOver()) {
                printLadderState("Final");
                break;
            }
        }
        return player.getxPosition();
    }

    private boolean isGameOver() {
        return player.getyPosition() == ladder.getHeight() - 1;
    }

    private void printLadderState(String state) {
        System.out.println(state);
        LadderPrinter.print(ladder, player);
    }
}

