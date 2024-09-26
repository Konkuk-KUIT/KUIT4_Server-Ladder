package ladder.wrapper;

public class unsignedInt {
    int value;

    private unsignedInt(int value) {
        if(value < 0){
            throw new IllegalArgumentException("Negative number");
        }
        this.value = value;
    }

    public static unsignedInt from(int value){
        return new unsignedInt(value);
    }

    public int getValue() {
        return this.value;
    }

    public void increment(){
        this.value++;
    }

}
