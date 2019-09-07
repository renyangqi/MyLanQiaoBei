package _03神奇算式;

import java.util.*;

public class Main {
    static int ans = 0;
    static boolean[] visited;
    static Set<String> set = new HashSet();
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        visited = new boolean[arr.length];
        Arrays.fill(visited, false);
        LinkedList<Integer> permutation = new LinkedList<>();
        generatePermutation(arr, 0, permutation);
        for (String str : set) {
            check(str);
        }
        System.out.println(ans/2);
    }

    private static void generatePermutation(int[] arr, int index, LinkedList<Integer> permutation) {
        if (index == arr.length) {
            String str = "";
            for (int i = 0; i < 4; i++) {
                str = str + permutation.get(i);
            }
            set.add(str);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(arr[i]);
                generatePermutation(arr, index + 1, permutation);
                visited[i] = false;
                permutation.removeLast();
            }
        }
    }

    private static void check(String str) {
        String model = sortString(str);

        int num1 = Integer.parseInt(str.substring(0, 1));
        int num1_1 = Integer.parseInt(str.substring(1, str.length()));
        String sum1 = num1 * num1_1 + "";
        if (sortString(sum1).equals(model)) {
            ans++;
        }

        int num2 = Integer.parseInt(str.substring(0, 2));
        int num2_2 = Integer.parseInt(str.substring(2, str.length()));
        String sum2 = num2 * num2_2 + "";
        if (sortString(sum2).equals(model)) {
            ans++;
        }

        int num3 = Integer.parseInt(str.substring(0, 3));
        int num3_3 = Integer.parseInt(str.substring(3, str.length()));
        String sum3 = num3 * num3_3 + "";
        if (sortString(sum3).equals(model)) {
            ans++;
        }


    }

    private static String sortString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        String sortStr = sb.toString();
        return sortStr;
    }
    /**
     *  不用求全排列可以使用四重for循环解决问题
     */

}
