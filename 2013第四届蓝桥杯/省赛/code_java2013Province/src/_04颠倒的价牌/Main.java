package _04颠倒的价牌;

import java.util.ArrayList;

public class Main {
    private static int[] reversed = new int[]{0, 1, 2, -1, -1, 5, 9, -1, 8, 6};

    public static void main(String[] args) {
        ArrayList<Integer> kui200duo = new ArrayList<>();
        ArrayList<Integer> zhuan800duo = new ArrayList<>();
        for (int i = 1000; i < 9999; i++) {
            if (!check(i)) {
                continue;
            }
            int IJianReverseI = i - getGenerateReversed(i);
            if (IJianReverseI > 200 && IJianReverseI < 300) {
                kui200duo.add(i);
            }
            int ReverseIJianI = getGenerateReversed(i) - i;
            if (ReverseIJianI > 800 && ReverseIJianI < 900) {
                zhuan800duo.add(i);
            }
        }
        for (Integer x : kui200duo) {
            for (Integer y : zhuan800duo) {
                int res = getGenerateReversed(x) - x + getGenerateReversed(y) - y;
                if (res == 558) {
                    System.out.print(x + " " + y+"\n");
                }
            }
        }
    }

    public static boolean check(int x) {
        String xStr = x + "";

        for (int i = 0; i < 4; i++) {
            if (xStr.charAt(i) == '3' || xStr.charAt(i) == '4' || xStr.charAt(i) == '7') {
                return false;
            }
        }
        if ((getGenerateReversed(x) + "").length() < 4) {
            return false;
        }
        return true;
    }

    public static int getGenerateReversed(int v) {
        String str = v + "";
        String one = str.substring(3, 4);
        String two = str.substring(2, 3);
        String three = str.substring(1, 2);
        String four = str.substring(0, 1);
        String ret = "";
        ret += reversed[Integer.parseInt(one)];
        ret += reversed[Integer.parseInt(two)];
        ret += reversed[Integer.parseInt(three)];
        ret += reversed[Integer.parseInt(four)];
        return Integer.parseInt(ret);
    }
}
