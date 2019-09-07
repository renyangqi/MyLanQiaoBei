package _09分巧克力.Solution2;

public class Main {
    public static void main(String[] args) {
        int N = 2;
        int K = 10;
        /*Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();*/
        int[][] heightAndWeight = new int[][]{{6, 5}, {5, 6}};
        int res = getLength(1, 10000, heightAndWeight, K);
        System.out.println(res);
    }

    //在长度为left 到 right中获得一个符合题目要求中的最大length
    private static int getLength(int left, int right, int[][] heightAndWeight, int K) {
        if (left >right) {
            return (left + right) / 2;
        }

        int len = (right - left) / 2 + left;
        int num = calculateNum(heightAndWeight, len);
        if (num >= K) {
            return getLength(len + 1, right, heightAndWeight, K);
        } else {
            return getLength(left, len - 1, heightAndWeight, K);
        }
    }

    private static int calculateNum(int[][] heightAndWeight, int len) {
        int num = 0;
        for (int j = 0; j < heightAndWeight.length; j++) {
            int height = heightAndWeight[j][0];
            int weight = heightAndWeight[j][1];
            num = num + (height / len) * (weight / len);
        }
        return num;
    }
}
