package _09磊骰子;

import java.util.Scanner;

/***
 *      东塔规划
 */
public class Main2 {
    static boolean[][] conflict = new boolean[7][7];
    static int[] opposite = new int[]{0, 4, 5, 6, 1, 2, 3};
    //memo[i][j] 表示的是第i层,将数字j朝上面 的能与下一层不冲突的总个数
    //状态转移方程 memo[1][1] = memo[0][1]*4+memo[0][2]*4...+memo[0][6]*4 (不包括冲突项)
    //状态转移方程 memo[2][1] = memo[1][1]*4+memo[1][2]*4...+memo[1][6]*4 (不包括冲突项)

    /**
     * 假设 1和2 不能紧贴在一起    1（4）表示 1 的对面是4
     * 上一层如果放1-6          1(4)     2(5)     3(6)    4(1)    5(2)    6(3)     sum
     * <p>
     * 2层 (4与1到6都不冲突）  24*4     24*4     24*4   20*4     20*4     24*4
     * 1层         (1-6朝上)    4        4        4       4       4       4         24
     * 动态规划自底向上
     * 解释为什么乘四 因为一个筛子比如1朝上 可以旋转有四种摆法
     */
    static long[][] memo = new long[2][7];

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
        for (int i = 0; i < 7; i++) {
            memo[0][i] = 4;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 7; j++) {
                for (int k = 1; k < 7; k++) {
                    if (conflict[opposite[j]][k] != true) {
                        memo[i % 2][j] += memo[(i - 1) % 2][j] * 4;
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
        long ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans += memo[(n - 1) % 2][i];
        }
        System.out.println("\n ans = " + ans);
    }
}
