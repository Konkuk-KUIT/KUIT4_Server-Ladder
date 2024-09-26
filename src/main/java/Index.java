public class Index {
    private int index;

    private Index(int index){
        this.index = index;
    }

    public static Index from(int index){
        if ( !validateIndex(index) ){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return new Index(index);
    }

    private static boolean validateIndex(int index) {
        return index >= 0;
    }

    public int getNumber(){
        return index;
    }

    public void move(Direction a) {
        this.index += a.getDirection();
    }
}
