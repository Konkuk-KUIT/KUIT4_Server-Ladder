package ladder.wrapper;

public class ArrayIndex {
    int index;

    private ArrayIndex(int index) {
        this.index = index;
    }

    public static ArrayIndex of(int index) {
        validateIndex(index);
        return new ArrayIndex(index);
    }

    private static void validateIndex(int index) {
        if (isInvalid(index)) {
            throw new IllegalArgumentException("index should be greater than or equal to zero");
        }
    }

    private static boolean isInvalid(int index) {
        return index < 0;
    }

    public int getIndex() {
        return index;
    }

    public void increment() {
        index++;
    }

    public void decrement() {
        index--;
    }
}
