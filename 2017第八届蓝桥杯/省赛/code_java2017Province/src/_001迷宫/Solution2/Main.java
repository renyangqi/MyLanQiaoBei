package _001迷宫.Solution2;

public class Main {


    public static void main(String[] args) {

        char[][] maze = {
                {'U', 'D', 'D', 'L', 'U', 'U', 'L', 'R', 'U', 'L'},
                {'U', 'U', 'R', 'L', 'L', 'L', 'R', 'R', 'R', 'U'},
                {'R', 'R', 'U', 'U', 'R', 'L', 'D', 'L', 'R', 'D'},
                {'R', 'U', 'D', 'D', 'D', 'D', 'U', 'U', 'U', 'U'},
                {'U', 'R', 'U', 'D', 'L', 'L', 'R', 'R', 'U', 'U'},
                {'D', 'U', 'R', 'L', 'R', 'L', 'D', 'L', 'R', 'L'},
                {'U', 'L', 'L', 'U', 'R', 'L', 'L', 'R', 'D', 'U'},
                {'R', 'D', 'L', 'U', 'L', 'L', 'R', 'D', 'D', 'D'},
                {'U', 'U', 'D', 'D', 'U', 'D', 'U', 'D', 'L', 'L'},
                {'U', 'L', 'R', 'D', 'L', 'U', 'U', 'R', 'R', 'R'}
        };

        int[][] visited = new int[10][10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                resetVisited(visited);
                boolean res = solve(i, j, visited, maze);
                if (res == true) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean solve(int x, int y, int[][] visited, char[][] maze) {
        if (x < 0 || x > 9 || y < 0 || y > 9) {
            return true;
        }
        if (visited[x][y] == 1) {
            return false;
        }
        visited[x][y] = 1;
        char c = maze[x][y];

        boolean res = false;
        switch (c) {
            case 'U':
                res = solve(x - 1, y, visited, maze);
                break;
            case 'D':
                res = solve(x + 1, y, visited, maze);
                break;
            case 'L':
                res = solve(x, y - 1, visited, maze);
                break;
            case 'R':
                res = solve(x, y + 1, visited, maze);
                break;
        }
        return res;
    }

    public static void resetVisited(int[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = 0;
            }
        }
    }

}



