package _09交换瓶子;

import java.util.Scanner;

public class Main {
    static int N = 0;
    static int[] arr;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        calculate();
        System.out.println(ans);
    }

    private static void calculate() {
        // 外层for循环寻找 元素 i+1 并把 元素i+1 放到第i个位置
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //  比如 1 3 2 4 5 则 1 和 1 自己不用交换
                if (arr[j] == i + 1 && i != j) {
                    swap(i, j);
                    ans++;
                }
            }
        }
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
