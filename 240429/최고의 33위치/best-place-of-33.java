import java.util.Scanner;

public class Main {
    static int[][] grid;

    static int calculate(int rs, int re, int cs, int ce) {
        int cnt = 0;

        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                cnt += grid[i][j];
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // solution
        int answer = 0;

        for (int r = 0; r < n; r++) {
            if (r + 2 >= n) break;

            for (int c = 0; c < n; c++) {
                if (c + 2 >= n) break;

                int cnt = calculate(r, r + 2, c, c + 2);
                answer = Math.max(answer, cnt);
            }
        }

        // output
        System.out.println(answer);
    }
}