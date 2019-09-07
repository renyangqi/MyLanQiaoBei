package _07剪邮票;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Main {
    //右下左上的偏移
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //染色的格子数
    static int num = 1;
    //多少种情况
    static LinkedHashSet set = new LinkedHashSet();

    public static void main(String[] args) {
        int[][] visited = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    num = 1;
                    dfs(i, j, visited);
                    visited[i][j] = 0;

                }
            }
        }

        for (Object o : set) {
            String x = (String) o;
            System.out.println(x);
        }
        /**
         *     0 1 0 0         0 0 1 0
         *     1 1 1 0   和    0 1 1 1
         *     0 1 0 0         0 0 1 0 不包括在内
         *
         */

        System.out.println(set.size() + 2);
    }

    private static void dfs(int x, int y, int[][] visited) {
        if (num == 4) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = 1;
                        if (check(visited) == true) {
                            set.add(toString(visited));
                        }
                        visited[i][j] = 0;
                    }
                }
            }

            return;
        }

        for (int k = 0; k < dir.length; k++) {
            int newx = dir[k][0] + x;
            int newy = dir[k][1] + y;
            if (inArea(newx, newy) && visited[newx][newy] == 0) {
                num++;
                visited[newx][newy] = 1;
                dfs(newx, newy, visited);
                visited[newx][newy] = 0;
                num--;
            }
        }

    }

    private static boolean check(int[][] visited) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (visited[i][j] == 1) {
                    if (near(i, j, visited) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean near(int x, int y, int[][] visited) {
        boolean res = false;
        for (int k = 0; k < dir.length; k++) {
            int newx = dir[k][0] + x;
            int newy = dir[k][1] + y;
            if (inArea(newx, newy)) {
                res = res || visited[newx][newy] == 1;
            }
        }
        return res;
    }


    private static String toString(int[][] visited) {
        String str = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                str = str + visited[i][j];
            }
            str = str + "\n";
        }
        return str;
    }

    private static boolean inArea(int x, int y) {
        return (x >= 0 && x < 3) && (y >= 0 && y < 4);
    }
}
