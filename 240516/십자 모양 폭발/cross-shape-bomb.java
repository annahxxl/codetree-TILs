import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j= 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        ///

        int num = grid[r][c];

        int rs = r - (num - 1) >= 0 ? r - (num - 1) : 0;
        int re = r + (num - 1) < n ? r + (num - 1) : n - 1;
        for(int i = rs; i <= re; i++) grid[i][c] = -1;

        int cs = c - (num - 1) >= 0 ? c - (num - 1) : 0;
        int ce = c + (num - 1) < n ? c + (num - 1) : n - 1; 
        for(int i = cs; i <= ce; i++) grid[r][i] = -1;

        int[][] answer = new int[n][n];

        for(int i = 0; i < n; i++) {
            int idx = n - 1;

            for(int j = n - 1; j >= 0; j--) {
                if(grid[j][i] == -1) continue;
                answer[idx][i] = grid[j][i];
                idx--;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}