import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        
        int[] dp = new int[m + 1];
        for(int i = 1; i <= m; i++)
            dp[i] = -1;
        for(int i = 0; i < n; i++)
            if (coins[i] <= m)
                dp[coins[i]] = 1;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    dp[i] = Math.max(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        System.out.println(dp[m]);
    }
}