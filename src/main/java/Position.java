public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position create(int x, int y) {
        return new Position(x, y);
    }

    // 해당 위치에 가로선을 그릴 수 있는지 검사
    public void checkValidity(int[][] array) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("값은 음수일 수 없습니다.");
        }

        if (x >= array.length) {
            throw new IllegalArgumentException("입력 가능한 높이 범위를 넘어갔습니다");
        }

        if (y >= array[0].length - 1) {
            throw new IllegalArgumentException("제일 끝에는 가로선을 넣을 수 없습니다.");
        }

        if (array[x][y] != 0) {
            throw new IllegalArgumentException("해당 위치에 이미 가로선이 존재합니다.");
        }
    }

    // 가로선을 그리는 메서드
    public void createLine(int[][] array) {
        checkValidity(array);
        array[x][y] = 1;   // 오른쪽 이동
        array[x][y + 1] = -1; // 왼쪽 이동
    }

}
