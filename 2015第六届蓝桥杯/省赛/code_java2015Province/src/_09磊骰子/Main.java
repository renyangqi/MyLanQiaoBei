package _09磊骰子;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 只能得到30%的分数
 */
public class Main {
    static boolean[][] conflict = new boolean[7][7];
    static int[] opposite = new int[]{0, 4, 5, 6, 1, 2, 3};

    public static void main(String[] args) {
        long answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            conflict[x][y] = true;
            conflict[y][x] = true;
        }
        for (int i = 1; i <= 6; i++) {
            // 当前点数为i朝上 放置剩下的n-1个筛子
            answer = answer + placeDice(i, n - 1);
        }

        System.out.println(answer % (1000000007));
    }

    // 上层点数为i朝上 放置剩下的n-1个筛子
    private static long placeDice(int num, int remander) {
        if (remander == 0) {
            return 4;
        }
        long ans = 0;
        for (int i = 1; i <= 6; i++) {
            int op = opposite[num];
            if (conflict[op][i] == true) {
                continue;
            }
            ans = ans + 4 * placeDice(i, remander - 1);
        }
        return ans;
    }

}
