import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            first[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            second[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][n + 1]; // 각 플레이어가 i, j 번째 카드를 버렸을 때 얻을 수 있는 최대 점수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                if (first[i + 1] < second[j + 1]) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                }

                if (first[i + 1] > second[j + 1]) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + second[j + 1]);
                }

                dp[i + 1][j + 1] = Math.max(dp[i][j], dp[i + 1][j + 1]);
            }
        }

        int answer = 0;
        for (int i = 0; i <= n; i++) {
            answer = Math.max(answer, dp[i][n]);
            answer = Math.max(answer, dp[n][i]);
        }

        System.out.println(answer);
    }
}