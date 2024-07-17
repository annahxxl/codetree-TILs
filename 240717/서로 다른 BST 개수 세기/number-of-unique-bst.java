import java.util.Scanner;

public class Main {
    private static int n;
    private static int[] dp; // memoization

    private static int bt(int n) {
        if(n == 1) return 1;

        if(dp[n] != 0) return dp[n];

        int cnt = 0;
        for(int i = 0; i < n; i++) 
            cnt += bt(i) * bt(n - i - 1);
        dp[n] = cnt;

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];
        dp[0] = 1;
        System.out.println(bt(n));
    }
}