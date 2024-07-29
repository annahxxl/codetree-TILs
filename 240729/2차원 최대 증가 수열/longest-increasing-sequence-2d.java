import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                for(int a = 0; a < i; a++) {
                    for(int b = 0; b < j; b++) {
                        if(grid[i][j] <= grid[a][b]) continue;
                        dp[i][j] = Math.max(dp[i][j], dp[a][b] + 1);
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                answer = Math.max(answer, dp[i][j]);

        System.out.println(answer);
    }
}