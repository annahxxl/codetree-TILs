import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        int[] nums = new int[] {1, 2, 5};

        dp[1] = 1;
        dp[2] = 1;
        dp[5] = 1;

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i >= nums[j]) {
                    dp[i] = (dp[i] + dp[i - nums[j]]) % 10007; 
                }
            }
        }

        System.out.println(dp[n]);        
    }
}