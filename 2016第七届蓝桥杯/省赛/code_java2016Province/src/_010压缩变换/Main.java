package _010压缩变换;

import java.util.*;

/**
 * 使用set去重统计个数只能拿到30%的分数 因此在Main2中使用更高级的线段树结构
 */
public class Main {
    static int N = 0;
    static int[] arr;
    static int[] arr2;

    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                arr2[i] = -1 * arr[i];
                map.put(arr[i], i);
            } else {
                // 最后一次出现的下标
                int lastIndex = map.get(arr[i]);
                int num = 0;

                Set<Integer> set = new LinkedHashSet<Integer>();
                for (int j = lastIndex + 1; j < i; j++) {
                    set.add(arr[j]);
                }
                num = set.size();
                arr2[i] = num;
                map.put(arr[i], i);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
