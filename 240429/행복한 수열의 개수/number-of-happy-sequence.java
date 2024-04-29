import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static int[][] grid;

    static boolean check(int[] arr) {
        int cnt = 1;
        int cur = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (cur == arr[i]) {
                cnt++;
                if (cnt == m) return true;
            } else {
                cnt = 1;
                cur = arr[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // solution
        for (int r = 0; r < n; r++) {
            if (check(grid[r])) answer++;
        }

        for (int c = 0; c < n; c++) {
            int[] arr = new int[n];
            
            for (int r = 0; r < n; r++) {
                arr[r] = grid[r][c];
            }

            if (check(arr)) answer++;
        }

        // output
        System.out.println(answer);
    }
}