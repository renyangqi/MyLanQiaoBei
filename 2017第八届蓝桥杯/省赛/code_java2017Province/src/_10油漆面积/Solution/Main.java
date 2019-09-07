package _10油漆面积.Solution;

public class Main {
    /**
     *
     * 暴力解法 更高级的解法是线段树
     */
    public static void main(String[] args) {
        int N = 3;
        int ans = 0;
        // int[][] block = new int[][]{{1, 5, 10, 10}, {3, 1, 20, 20}, {2, 7, 15, 17}};
        int[][] block = new int[][]{{5, 2, 10, 6}, {2, 7, 12, 10}, {8, 1, 15, 15}};

        boolean[][] memo = new boolean[10001][10001];
        for (int i = 0; i < block.length; i++) {
            //刷油漆 已经刷过的格子不用再刷
            Crushroller(block[i], memo);
        }
        for (int i = 0; i < 10001; i++) {
            for (int j = 0; j < 10001; j++) {
                if (memo[i][j] == true) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void Crushroller(int[] block, boolean[][] memo) {
        int x1 = block[0];
        int y1 = block[1];
        int x2 = block[2];
        int y2 = block[3];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                memo[i][j] = true;
            }
        }
    }
}
