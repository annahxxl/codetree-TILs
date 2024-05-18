import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        
        int[] dp = new int[n]; // 마지막 숫자가 idx 번째 숫자
        dp[0] = 1;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < i; j++)
                if(nums[j] > nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

        int answer = 0;

        for(int i = 0; i < n; i++)
            answer = Math.max(answer, dp[i]);

        System.out.println(answer);
    }
}