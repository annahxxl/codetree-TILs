import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        
        int[] dp = new int[m + 1];
        for(int i = 0; i <= m; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j - nums[i] >= 0 && dp[j - nums[i]] != Integer.MAX_VALUE) {
                    dp[j] = dp[j - nums[i]] + 1;
                }
            }
        }

        System.out.println(dp[m] != Integer.MAX_VALUE ? "Yes" : "No");
    }
}