package _01猜年龄;

public class Main {
    static int min = 1;
    static int max = min + 1;

    public static void main(String[] args) {

        for (int i = 1; i < 100; i++) {
            for (int j = i + 1; j <= i + 8; j++) {
                check(i, j);

            }
        }
        // 小的妹妹年龄是10
    }

    private static void check(int i, int j) {
        if (i * j == 6 * (i + j)) {
            System.out.println("i = " + i + " j = " + j);
        }
    }
}
