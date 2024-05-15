import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[m + 1];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        for(int i = 1; i <= m; i++)
            dp[i] = -1;
        
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j - nums[i] == 0) {
                    dp[j] = 1;
                    continue;
                }
                if(j - nums[i] > 0 && dp[j - nums[i]] != -1) {
                    dp[j] = dp[j] == -1 ? dp[j - nums[i]] + 1 : Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
        } 

        System.out.println(dp[m]);
    }
}