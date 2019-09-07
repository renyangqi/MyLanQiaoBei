package _02李白打酒;

public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        int drug = 2;
        int a = 5;
        int b = 9;
        //目前有两斗酒
        go(drug, a, b);
        System.out.println(ans);
    }

    //李白还剩drug斗酒且还能遇到 a次店 b次花 求有多少种走法
    private static void go(int drug, int a, int b) {
        if (a == 0 && b == 0 && drug == 1) {
            ans++;
        }
        if (a > 0) {
            go(2 * drug, a - 1, b);
        }
        if (b > 0) {
            go(drug - 1, a, b - 1);
        }
    }
}
