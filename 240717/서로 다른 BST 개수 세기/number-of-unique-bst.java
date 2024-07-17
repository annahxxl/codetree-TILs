import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                cnt += dp[j] * dp[n - j - 1];
            }
            dp[i] = cnt;
        }

        System.out.println(dp[n]);
    }
}