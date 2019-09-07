package _06寒假作业;

public class Main {
    static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    static int ans = 0;

    public static void main(String[] args) {

        generatePermutation(0);
        System.out.println(ans);
    }

    private static void generatePermutation(int index) {
        if (index == arr.length) {
            int[] clone = arr.clone();
            check(clone);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(index, i);
            if (
                    (index == 2 && arr[0] + arr[1] != arr[2]) ||
                            (index == 5 && arr[3] - arr[4] != arr[5])) {
                swap(index, i);
                continue;
            }
            generatePermutation(index + 1);
            swap(index, i);
        }
    }

    private static void swap(int index, int i) {
        int t = arr[index];
        arr[index] = arr[i];
        arr[i] = t;
    }

    private static void check(int[] clone) {
        if (clone[0] + clone[1] == clone[2] &&
                clone[3] - clone[4] == clone[5] &&
                clone[6] * clone[7] == clone[8] &&
                clone[9] % clone[10] == 0 &&
                clone[9] / clone[10] == clone[11]
        ) {
            ans++;
        }
    }
}
