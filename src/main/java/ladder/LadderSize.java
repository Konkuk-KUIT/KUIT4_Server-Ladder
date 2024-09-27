package ladder;

import static ladder.ExceptionMessage.INVALID_LADDER_NUMBER;

public class LadderSize {
    private final GreaterThanOne  numberOfRows;
    private final GreaterThanOne  numberOfPersons;

    public LadderSize(int numberOfRows, int numberOfPersons) {
        validate(numberOfRows, numberOfPersons);
        this.numberOfRows = new GreaterThanOne(numberOfRows);
        this.numberOfPersons = new GreaterThanOne (numberOfPersons);
    }

    public int getNumberOfRows() {
        return numberOfRows.getNumber();
    }

    public int getNumberOfPersons() {
        return numberOfPersons.getNumber();
    }
    private void validate(int numberOfRows, int numberOfPersons) {
        if (numberOfRows < 2 || numberOfPersons < 2) {
            throw new IllegalArgumentException(INVALID_LADDER_NUMBER.getMessage());
        }
    }

}
