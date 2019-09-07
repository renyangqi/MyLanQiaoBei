package _02生日蜡烛;

public class Main2 {
    public static void main(String[] args) {
        // i j 都是年龄 j-i+1是项数
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if ((i + j) * (j - i + 1) / 2 == 236) {
                    System.out.println("i = " + i + " j = " + j);
                    break;
                }
            }
        }
    }
}
