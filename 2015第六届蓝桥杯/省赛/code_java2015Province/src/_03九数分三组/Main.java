package _03九数分三组;

import java.util.*;

public class Main {
    static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] arr2 = new int[arr.length];
    static boolean[] visited = new boolean[9];
    static LinkedList<Integer> ans = new LinkedList<Integer>();
    static Set<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        generatePermutation(0);
        for (Integer item : set) {
            System.out.print(item+" ");
        }
    }

    private static void generatePermutation(int index) {
        if (index == arr.length) {
            int x = arr2[0] * 100 + arr2[1] * 10 + arr2[2];
            int y = arr2[3] * 100 + arr2[4] * 10 + arr2[5];
            int z = arr2[6] * 100 + arr2[7] * 10 + arr2[8];
            int[] ABC = {x, y, z};
            Arrays.sort(ABC);
            int A = ABC[0];
            int B = ABC[1];
            int C = ABC[2];
            if (A * 2 == B && A * 3 == C) {
                if (!set.contains(A)) {
                    set.add(A);
                    System.out.println("A = " + A + " B = " + B + " C = " + C);
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr2[index] = arr[i];
                generatePermutation(index + 1);
                visited[i] = false;
            }
        }
    }
}
