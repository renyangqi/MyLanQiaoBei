package _01熊怪吃核桃;

public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        recursion(1543);
        System.out.println(ans);
    }

    private static void recursion(int num) {
        if (num == 0) {
            return;
        }
        if (num % 2 == 1) {
            ans++;
        }
        recursion(num / 2);
    }
}
