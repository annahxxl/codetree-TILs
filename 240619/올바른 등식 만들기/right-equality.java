import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n + 1];
        for(int i = 1; i <= n; i++)
            nums[i] = sc.nextInt();
        
        int offset = 20;
        long[][] dp = new long[101][41];
        dp[0][0 + offset] = 1;
        m += offset;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= 40; j++) {
                if(j + nums[i] <= 40)
                    dp[i][j] += dp[i - 1][j + nums[i]];
                if(j - nums[i] >= 0)
                    dp[i][j] += dp[i - 1][j - nums[i]];
            }
        }

        System.out.println(dp[n][m]);
    }
}