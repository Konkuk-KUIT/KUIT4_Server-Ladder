public class LadderGameFactory {
    public static LadderGame createRandomLadderGame(int rows, int columns) {
        LadderCreator creator = new RandomLadderCreator();
        Ladder ladder = creator.createLine(rows, columns);
        return new LadderGame(ladder);
    }
}
