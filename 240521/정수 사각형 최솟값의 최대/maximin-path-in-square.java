import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int answer = 0;
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = Integer.MAX_VALUE;
        
        dp[0][0] = grid[0][0];

        for(int i = 1; i < n; i++)
            dp[i][0] = Math.min(grid[i][0], dp[i - 1][0]);
        
        for(int i = 1; i < n; i++)
            dp[0][i] = Math.min(grid[0][i], dp[0][i - 1]);

        for(int i = 1; i < n; i++)
            for(int j = 1; j < n; j++)
                dp[i][j] = Math.max(Math.min(grid[i][j], dp[i - 1][j]), Math.min(grid[i][j], dp[i][j - 1]));
        
        System.out.println(dp[n - 1][n - 1]);
    }
}