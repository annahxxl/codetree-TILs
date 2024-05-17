import java.util.Scanner;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n + 1][10]; // i번째까지 선택, 마지막으로 선택한 수가 j

        for(int i = 1; i <= 9; i++)
            dp[1][i] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % MOD;
                } else if(j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        int answer = 0;

        for(int i = 0; i <= 9; i++)
            answer =  (answer + dp[n][i]) % MOD;
        
        System.out.println(answer);
    }
}