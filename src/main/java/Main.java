

public class Main {

    public static void main(String[] args) {

        Ladder ladder = new Ladder(Row.from(5), NumberOfPerson.from(5));

        ladder.drawLine(new Position(Row.from(1), Col.from(2)));
        ladder.drawLine(new Position(Row.from(2), Col.from(3)));
        ladder.drawLine(new Position(Row.from(3), Col.from(4)));
        ladder.drawLine(new Position(Row.from(4), Col.from(5)));

        System.out.println(ladder.run(Col.from(1)));

    }
}
