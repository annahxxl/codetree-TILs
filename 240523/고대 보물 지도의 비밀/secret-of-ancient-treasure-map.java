import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        
        int[][] dp = new int[n][k + 1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j <= k; j++)
                dp[i][j] = -30000;
        
        if(nums[0] >= 0) {
            dp[0][0] = nums[0];
        } else {
            dp[0][1] = nums[0];
        }
        int answer = nums[0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++) {
                int num = nums[i];
                if(num >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j] + num, num);
                } else if(j > 0) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + num, num);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}