package _09磊骰子;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 矩阵法 能获得全部分数
 */
public class Main3 {
    //由Main2的动态规划演变成 线性代数

    //T冲突矩阵
    static int[] op = new int[]{0, 4, 5, 6, 1, 2, 3};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] T = new int[7][7];
        for (int i = 0; i < 7; i++) {
            Arrays.fill(T[i], 1);
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            T[op[a]][b] = 0;
            T[op[b]][a] = 0;
        }
        Print(T);
        //求T 的n-1次方 然后将 T[1][1]到T[6][6] 的6*6矩阵全部加起来
        int[][] res = getPow(T, n - 1);
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                ans += res[i][j];
            }
        }
        System.out.println("结果 = " + ans*Math.pow(4,n));

    }

    private static int[][] getPow(int[][] T, int n) {
        if (n == 1) {
            return T;
        }
        int[][] x = getPow(T, n / 2);
        int[][] res = mul(x, x);
        if (n % 2 == 1) {
            res = mul(res, res);
        }
        return res;
    }

    private static int[][] mul(int[][] x, int[][] y) {
        int[][] ret = new int[7][7];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    ret[i][j] += x[i][k] * y[j][k];
                }
            }
        }
        return ret;
    }


    private static void Print(int[][] T) {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(T[i][j] + " ");
            }
            System.out.println();
        }
    }
}
