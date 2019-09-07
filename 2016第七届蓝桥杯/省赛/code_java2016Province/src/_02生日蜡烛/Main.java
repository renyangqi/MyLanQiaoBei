package _02生日蜡烛;

public class Main {
    static int CurrentYear = 0;

    public static void main(String[] args) {
        int start = 100;
        int sum = 236;
        for (int i = start; i >= 1; i--) {
            if (getNum(236, i) == true) {
                CurrentYear = i;
                System.out.println(i);
                break;
            }
        }
        int x = 0;
        for (int i = CurrentYear; i >= 1; i--) {
            x = x + i;
            if(x == sum){
                System.out.println(i);
            }
        }

    }

    // sum 从deleteNum 开始.每次删除低于delete的连续数字判断是否能过正好sum为0
    private static boolean getNum(int sum, int deletenum) {
        sum = sum - deletenum;
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        boolean res = getNum(sum, deletenum - 1);
        return res;
    }
}
