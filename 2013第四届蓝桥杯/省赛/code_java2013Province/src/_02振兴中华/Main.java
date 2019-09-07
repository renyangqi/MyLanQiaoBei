package _02振兴中华;

import java.util.LinkedList;

public class Main {
    //右 下 左 上
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int ans = 0;

    public static void main(String[] args) {
        char[][] c = new char[][]{
                {'从', '我', '做', '起', '振'},
                {'我', '做', '起', '振', '兴'},
                {'做', '起', '振', '兴', '中'},
                {'起', '振', '兴', '中', '华'}
        };
        LinkedList<Character> list = new LinkedList<>();
        dfs(c, 0, 0, list);
        System.out.println(ans);
    }

    private static void dfs(char[][] c, int x, int y, LinkedList<Character> list) {
        list.add(c[x][y]);
        if (list.size() == 8) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                builder.append(list.get(i));
            }
            if (builder.toString().equals("从我做起振兴中华")) {
                System.out.println("从我做起振兴中华");
                ans++;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if (inArea(newx, newy)) {
                dfs(c, newx, newy, list);
                list.removeLast();
            }

        }

    }

    public static boolean inArea(int x, int y) {
        return x >= 0 && x <= 3 && y >= 0 && y <= 4;
    }
}
