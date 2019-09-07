package _06加法变乘法;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[49];
        char[] symbol = new char[48];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < symbol.length; i++) {
            symbol[i] = '+';
        }

        for (int i = 0; i < symbol.length; i++) {
            symbol[i] = '*';
            for (int j = i + 2; j < symbol.length; j++) {
                symbol[j] = '*';
                if (calculate(arr, symbol) == 2015) {
                    System.out.println("\n" + arr[i]);//得出结果为16
                } else {
                    symbol[j] = '+';
                }

            }
            symbol[i] = '+';
        }

        calculate(arr, symbol);

    }

    private static int calculate(int[] arr, char[] symbol) {
        int sum = 1;
        for (int i = 0; i < symbol.length; i++) {
            if (symbol[i] == '+') {
                sum = sum + arr[i + 1];
            } else {
                sum = sum - arr[i];
                sum = sum + arr[i] * arr[i + 1];
            }
        }
        if (sum == 2015) {
            for (int i = 0; i < symbol.length; i++) {
                System.out.print("" + arr[i] + symbol[i] + "");
            }
            System.out.print(arr[48]);
        }
        return sum;
    }
}
