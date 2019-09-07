package _002九数算式.Solution1;

import java.util.*;


public class Main {
    static int count = 0;
    static boolean visited[] = new boolean[10];
    static int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        dfs(nums, 0, list);
        System.out.println(count / 2);
    }

    // p中保存了一个有index个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index+1个元素的排列
    //生成一个全排列 比如 2013456789 其中0是乘号将排列分成两半
    private static void dfs(int[] nums, int index, LinkedList<Integer> list) {
        if (index == nums.length) {
            String permutationString = getString(list);

            int zeroIndex = permutationString.indexOf("0");
            if (zeroIndex == 0 || zeroIndex == 9) {
                return;
            }
            String[] split = permutationString.split("0");
            int leftNum = Integer.parseInt(split[0]);
            int rightNum = Integer.parseInt(split[1]);
            if (check(leftNum, rightNum) == true) {
                System.out.println("leftNum " + leftNum + " rightNum " + rightNum + " Sum " + rightNum * leftNum + "");
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                list.add(i);
                dfs(nums, index + 1, list);
                list.removeLast();
                visited[i] = false;
            }
        }

    }

    private static boolean check(int leftNum, int rightNum) {
        String res = leftNum * rightNum + "";
        char[] chars = res.toCharArray();
        if (chars.length != 9) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        return set.size() == 9 && !set.contains('0');
    }

    private static String getString(LinkedList list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i);
        }

        return str;
    }
}
