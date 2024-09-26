public class LadderGame {
    private LadderCreator ladderCreator;
    private RunGame runGame;

    public LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public int run(int startLine) {
        runGame = new RunGame(ladderCreator.getRow());

        return runGame.run(startLine);
    }
}
