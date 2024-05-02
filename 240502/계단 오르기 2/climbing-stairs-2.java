import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coin = new int[1001];
        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
        }

        int[][] dp = new int[1001][4];
        dp[1][1] = coin[1];
        dp[2][0] = coin[2];
        dp[2][2] = coin[1] + coin[2];

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {
                if (dp[i - 2][j] != 0) { // 2계단을 오르는 경우, 가능하다면
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j] + coin[i]);
                }
                if (j > 0 && dp[i - 1][j - 1] != 0) { // 1계단을 오르는 경우, 가능하다면
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + coin[i]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 3; i++) {
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}