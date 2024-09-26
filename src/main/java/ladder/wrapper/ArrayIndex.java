package ladder.wrapper;

import ladder.constants.ExceptionMessage;

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
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
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
