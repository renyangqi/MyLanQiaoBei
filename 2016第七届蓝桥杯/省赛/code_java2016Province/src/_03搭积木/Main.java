package _03搭积木;

import java.util.ArrayList;

public class Main {
    static int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int ans = 0;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans);
    }

    private static void f(int k) {
        if (k == arr.length) {
            ans++;
        }
        for (int i = k; i < arr.length; i++) {
            //产生了新的排列
            swap(k, i);
            //判断是否符合题目要求
            if (k == 1 && arr[1] < arr[0] ||
                    k == 2 && arr[2] < arr[0] ||
                    k == 3 && arr[3] < arr[1] ||
                    k == 4 && (arr[4] < arr[1] || arr[4] < arr[2]) ||
                    k == 5 && arr[5] < arr[2] ||
                    k == 6 && arr[6] < arr[3] ||
                    k == 7 && (arr[7] < arr[3] || arr[7] < arr[4]) ||
                    k == 8 && (arr[8] < arr[4] || arr[8] < arr[5]) ||
                    k == 9 && arr[9] < arr[5]
            ) {
                swap(k, i);
                continue;
            }
            f(k + 1);
            swap(k, i);
        }
    }

    private static void swap(int k, int i) {
        int t = arr[k];
        arr[k] = arr[i];
        arr[i] = t;
    }
}
