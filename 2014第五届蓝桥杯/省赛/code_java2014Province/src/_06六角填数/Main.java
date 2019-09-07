package _06六角填数;

public class Main {
    static int[] arr = new int[]{2, 4, 5, 6, 7, 9, 10, 11, 12};
    static int ans = 0;

    public static void main(String[] args) {
        generatePermutation(0);
    }

    private static void generatePermutation(int index) {
        if (index == arr.length) {
            check();
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(index, i);
            generatePermutation(index + 1);
            swap(index, i);
        }
    }

    private static void swap(int index, int i) {
        int temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    private static void check() {
        int sum1 = 8 + arr[0] + arr[1] + arr[2];
        int sum2 = arr[2] + arr[4] + arr[7] + 3;
        int sum3 = 8 + arr[3] + arr[6] + 3;

        int sum4 = 1 + arr[1] + arr[4] + arr[8];
        int sum5 = arr[5] + arr[6] + arr[7] + arr[8];
        int sum6 = 1 + arr[0] + arr[3] + arr[5];

        if (sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 && sum5 == sum6) {
            ans = arr[3];
            System.out.println(ans);
        }
    }
}
