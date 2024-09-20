public class NaturalNum {
    private int naturalNum;

    // static 메소드로 객체 생성하기 때문에, 생성자는 private으로 변경하였음
    // Factory method와 private 생성자 (by study)
    private NaturalNum() {
    }

    private NaturalNum(int naturalNum) {

        if(checkNaturalNum(naturalNum)) {
            this.naturalNum = naturalNum;
        }

    }

    // Without making instance, can get naturalNum from int parameter
    public static NaturalNum from(int i) {
        return new NaturalNum(i);
    }

    public int getNaturalNum() {
        return naturalNum;
    }

    public boolean checkNaturalNum(int naturalNum) {
        if(naturalNum < 1) {
            throw new IllegalArgumentException("Natural number must be positive");
        }
        return true;
    }

}
