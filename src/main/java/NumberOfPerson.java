public class NumberOfPerson {

    private final int numberOfPerson;

    private NumberOfPerson(int numberOfPerson) {

        if(numberOfPerson < 1) {
            throw new IllegalArgumentException("사람은 1명 이상이어야합니다.");
        }

        this.numberOfPerson = numberOfPerson;
    }

    public static NumberOfPerson from(int numberOfPerson) {
        return new NumberOfPerson(numberOfPerson);
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }
}
