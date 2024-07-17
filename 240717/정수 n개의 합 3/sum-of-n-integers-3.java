import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                arr[i][j] = sc.nextInt();
        
        int[][] ps = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + arr[i][j];
        
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i < k || j < k) continue;
                answer = Math.max(answer, ps[i][j] - ps[i - k][j] - ps[i][j - k] + ps[i - k][j - k]);
            }
        }

        System.out.println(answer);
    }
}