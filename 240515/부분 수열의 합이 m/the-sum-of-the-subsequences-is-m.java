import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int MAX_VALUE = 10000; 
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[m + 1];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        for(int i = 1; i <= m; i++)
            dp[i] = MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = m; j >= 0; j--) {
                if(j >= nums[i])
                    dp[j] =  Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        } 

        System.out.println(dp[m] == MAX_VALUE ? -1 : dp[m]);
    }
}