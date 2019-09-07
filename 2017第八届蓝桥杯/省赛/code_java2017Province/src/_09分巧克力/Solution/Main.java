package _09分巧克力.Solution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N = 2;
        int K = 10;
        /*Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();*/
        int[][] heightAndWeight = new int[][]{{16, 16}, {1,1}};

        int right = 10001;
        int left = 1;
        int len = 0;
        while (left <= right) {
            //可以切出符合要求的巧克力块数
            int num = 0;
            //二分搜索 len 其实就是mid
            len = (right - left) / 2 + left;
            num = calculateNum(heightAndWeight, len);
            if (num >= K) {
                left = len + 1;
            } else {
                right = len - 1;
            }
        }
        System.out.println((left+right)/2);
    }

    private static int calculateNum(int[][] heightAndWeight, int len) {
        int num = 0;
        for (int j = 0; j < heightAndWeight.length; j++) {
            int height = heightAndWeight[j][0];
            int weight = heightAndWeight[j][1];
            num = num + (height / len) * (weight / len);
        }
        return num;
    }
}
