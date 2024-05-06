import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         int n = sc.nextInt();
         int m = sc.nextInt();
         int[][] clothes = new int[n + 1][3];

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                clothes[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[m + 1][n + 1]; // i번째 날까지 선택 완료, 마지막으로 고른 옷의 위치가 j라고 했을 때, 만족도

        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                dp[i][j] = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++)
            if(clothes[i][0] == 1)
                dp[1][i] = 0;

        for(int i = 2; i <= m; i++) {
            for(int j = 1; j <= n; j++) { 
                for(int k = 1; k <= n; k++) {
                    if(clothes[k][0] <= i - 1 && clothes[k][1] >= i - 1 && clothes[j][0] <= i && clothes[j][1] >= i)
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(clothes[k][2] - clothes[j][2]));
                }
            }            
        }

        int answer = 0;

        for(int i = 1; i <= n; i++)
            answer = Math.max(answer, dp[m][i]);

        System.out.println(answer);
    }
}