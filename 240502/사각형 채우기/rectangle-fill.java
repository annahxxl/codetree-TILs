import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[1001];

        dp[0] = 1; // 타일을 전혀 놓지 않는 경우 1가지
        dp[1] = 1;
        // dp[2] = 2;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 끝에 세로 1개 붙이는 경우, 끝에 가로 2개 붙이는 경우
        }

        System.out.println(dp[n]);
    }
}