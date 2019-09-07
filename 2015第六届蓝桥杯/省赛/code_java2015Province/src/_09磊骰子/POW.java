package _09磊骰子;

public class POW {
    // 求2的n次方的递归代码
    public static void main(String[] args) {
        int num = 2;
        int k = 9;
        int res = pow(num, k);
        System.out.println(res);
    }

    private static int pow(int num, int k) {
        if (k == 0) {
            return 1;
        }
        int x = pow(num, k / 2);
        int res = x * x;
        if (k % 2 == 1) {
            res = res * num;
        }
        return res;
    }
}
