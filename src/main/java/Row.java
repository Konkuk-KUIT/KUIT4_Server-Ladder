import java.util.Random;

public class Row {
    private Node[] cols;

    public Row(Index numberOfPerson) {
        cols = new Node[numberOfPerson.getNumber()];
        SetNodes();
    }

    private void SetNodes() {
        for (int i=0; i < cols.length; i++) {
            cols[i] = new Node(Direction.NONE);
        }
    }

    public void setValue(Index y, Direction direction) {
        cols[y.getNumber()].SetNode(direction);
    }

    public Node getValue(Index y) {
        return cols[y.getNumber()];
    }

    public int getPeopleNum() {
        return cols.length;
    }

    public void PrintRow(int col) {
        for (int i=0; i < cols.length; i++) {
            cols[i].printDirectionNumber();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void PrintRowWithStar(int col) {
        for (int i=0; i < cols.length; i++) {
            cols[i].printDirectionNumber();
            if (CheckCurrentPosition(col, i)) {System.out.print("*");}
            System.out.print(" ");
        }
        System.out.println();
    }

    public boolean CheckCurrentPosition(int col, int i) {
        return col == i;
    }
}
