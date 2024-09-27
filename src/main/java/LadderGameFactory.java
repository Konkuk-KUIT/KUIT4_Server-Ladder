public class LadderGameFactory {
    static LadderGame ladderGame;

    public static LadderGame createLadderGame(Index rowNum, Index numberOfPerson) {
        LadderCreator ladderCreator = new LadderCreator(rowNum, numberOfPerson, false);
        ladderGame = new LadderGame(ladderCreator);

        return ladderGame;
    }

    public static LadderGame createRandomLadderGame(Index rowNum, Index numberOfPerson) {
        LadderCreator ladderCreator = new LadderCreator(rowNum, numberOfPerson, true);
        ladderGame = new LadderGame(ladderCreator);

        return ladderGame;
    }


}
