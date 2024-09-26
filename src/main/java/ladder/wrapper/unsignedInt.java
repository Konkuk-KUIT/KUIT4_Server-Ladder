package ladder.wrapper;

import ladder.constants.ExceptionMessage;

public class unsignedInt {
    int value;

    private unsignedInt(int value) {
        this.value = value;
    }

    public static unsignedInt from(int value){
        validateUnsignedInteger(value);
        return new unsignedInt(value);
    }

    private static void validateUnsignedInteger(int value) {
        if(value < 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NATURAL_NUMBER.getMessage());
        }
    }

    public int getValue() {
        return this.value;
    }

    public void increment(){
        this.value++;
    }

}
