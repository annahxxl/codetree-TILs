import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dp = new int[10001];
        
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        System.out.println(dp[n] % 10007);
    }
}