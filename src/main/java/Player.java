public class Player {
    private int xPosition;
    private int yPosition;

    public Player(int startPosition) {
        // 사다리는 0부터 시작하기 때문에
        this.xPosition = startPosition-1;
        this.yPosition = 0;
        validatePosition();
    }

    private void validatePosition(){
        if(this.xPosition<0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_START_POSITION.getMessage());
        }
    }

    public void right(){
        this.xPosition += 1;
    }

    public void left(){
        this.xPosition -= 1;
    }

    public void down(){
        this.yPosition += 1;
    }

    public int getStartPosition() {
        return xPosition;
    }

    public int getxPosition(){
        return xPosition;
    }

    public int getyPosition(){
        return yPosition;
    }
}
