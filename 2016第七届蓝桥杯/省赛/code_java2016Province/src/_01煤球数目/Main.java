package _01煤球数目;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <=100 ; i++) {
            sum+=getLevelNum(i);
        }
        System.out.println(sum);
    }
    private static int getLevelNum(int n){
        return (n+1)*n/2;
    }
}
