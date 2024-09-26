public class LadderPrinter {

    // 정적메소드 적용
    public static void print(Ladder ladder, Player player) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            for (int j = 0; j < ladder.getWidth(); j++) {
                System.out.print(ladder.getRows(i, j));
                if (player.getxPosition() == j && player.getyPosition() == i) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}