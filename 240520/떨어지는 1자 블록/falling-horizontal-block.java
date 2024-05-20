import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int r = -1;
        boolean run = true;

        while(run) {
            int nr = r + 1;
            if(nr >= n) break;

            for(int i = k - 1; i < k + m - 1; i++) {
                if(grid[nr][i] == 1) {
                    run = false;
                    break;
                }
            }

            if (run) r = nr;
        }

        if(r >= 0) {
            for(int i = k - 1; i < k + m - 1; i++)
                    grid[r][i] = 1;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}