package _08移动距离;

import java.util.Scanner;

public class Main {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /* int w = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();*/
        int w = 6;

        int m = 8;
        int n = 2;


        int height = (19 / w) + 1;

        int[][] block = new int[height][w];
        for (int i = 0; i < w; i++) {
            block[0][i] = i + 1;
        }

        for (int i = 1; i < block.length; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < w; j++) {
                    block[i][j] = block[i - 1][j] + (2 * w - 1 - 2 * j);
                }
            } else {
                for (int j = 0; j < w; j++) {
                    block[i][j] = block[i - 1][j] + (2 * j + 1);
                }
            }
        }


        Print(block, height, w);
        int res = calculate(block, m, n, w);
        System.out.println(res);

    }

    private static int calculate(int[][] block, int m, int n, int w) {

        int[] mXY = get(m, w, block);
        int mlocalX = mXY[0];
        int mlocalY = mXY[1];


        int[] nXY = get(n, w, block);
        int nlocalX = nXY[0];
        int nlocalY = nXY[1];

        int res = Math.abs(mlocalX - nlocalX) + Math.abs(mlocalY - nlocalY);
        return res;
    }


    private static int[] get(int x, int w, int[][] block) {
        int line = x / w;
        if (x % w == 0) {
            line = line - 1;
        }

        for (int i = 0; i < w; i++) {
            if (block[line][i] == x) {
                return new int[]{line, i};
            }
        }
        return null;
    }

    private static void Print(int[][] block, int height, int w) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(block[i][j] + " ");
            }
            System.out.println();
        }
    }

}
