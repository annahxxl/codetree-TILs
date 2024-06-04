import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] room = new int[n + 1][3];
        for(int i = 1; i <= n; i++)
            for(int j = 0; j < 3; j++)
                room[i][j] = sc.nextInt();

        int[][] dp = new int[n + 1][3];
        for(int i = 1; i <= n; i++)
            for(int j = 0; j < 3; j++)
                for(int k = 0; k < 3; k++)
                    if(j != k)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + room[i][j]);

        int answer = 0;
        for(int i = 0; i < 3; i++) answer = Math.max(answer, dp[n][i]);
        System.out.println(answer);
    }
}