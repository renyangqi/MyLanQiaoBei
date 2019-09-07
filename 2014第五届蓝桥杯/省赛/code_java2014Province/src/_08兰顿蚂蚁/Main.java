package _08兰顿蚂蚁;

public class Main {
    public static void main(String[] args) {
        int m = 5;
        int n = 6;
        int[][] Graph = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Graph[i][j] = 0;
            }
        }
        Graph[2][2] = 1;
        //蚂蚁的位置
        int x = 2;
        int y = 3;
        dfs(Graph, x, y, 'L', 5);
        //******************************************************
        int m2 = 3;
        int n2 = 3;
        int[][] Graph2 = new int[m2][n2];
        for (int i = 1; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                Graph[i][j] = 1;
            }
        }
        //蚂蚁的位置
        int x2 = 1;
        int y2 = 1;
        dfs(Graph, x2, y2, 'U', 6);
    }

    private static void dfs(int[][] Graph, int x, int y, char s, int k) {
        if (k == 0) {
            System.out.println("x = " + x + " y = " + y);
            return;
        }
        if (Graph[x][y] == 1) {
            Graph[x][y] = 0;
            char dir = clockwiseRotation(s);
            int[] offset = Offset(dir);
            int newX = x + offset[0];
            int newY = y + offset[1];
            dfs(Graph, newX, newY, dir, k - 1);
        } else {
            Graph[x][y] = 1;
            char dir = counterclockwiseRotation(s);
            int[] offset = Offset(dir);
            int newX = x + offset[0];
            int newY = y + offset[1];
            dfs(Graph, newX, newY, dir, k - 1);
        }
    }

    private static int[] Offset(char dir) {
        if (dir == 'U') {
            return new int[]{-1, 0};
        } else if (dir == 'R') {
            return new int[]{0, 1};
        } else if (dir == 'D') {
            return new int[]{1, 0};
        } else {
            return new int[]{0, -1};
        }
    }

    //顺时针
    private static char clockwiseRotation(char s) {
        if (s == 'U') {
            return 'R';
        }
        if (s == 'R') {
            return 'D';
        }
        if (s == 'D') {
            return 'L';
        }
        return 'U';
    }

    //逆时针
    private static char counterclockwiseRotation(char s) {
        if (s == 'U') {
            return 'L';
        }
        if (s == 'L') {
            return 'D';
        }
        if (s == 'D') {
            return 'R';
        }
        return 'U';
    }
}
