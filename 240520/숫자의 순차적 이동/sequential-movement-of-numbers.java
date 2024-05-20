import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        ///
        
        int[][] dir = new int[][] { {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1} };
        int turnCnt = 1;
        
        while(turnCnt <= m) {
            int ci = -1, cj = -1;

            for(int k = 1; k <= n * n; k++) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(grid[i][j] == k) {
                            ci = i;
                            cj = j;
                        }
                    }
                }

                int maxNum = 0;
                int mx = ci, my = cj;

                for(int t = 0; t < dir.length; t++) {
                    int nx = ci + dir[t][0];
                    int ny = cj + dir[t][1];
                    
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] > maxNum) {
                        maxNum = grid[nx][ny];
                        mx = nx;
                        my = ny;
                    }
                }

                int tmp = grid[ci][cj];
                grid[ci][cj] = grid[mx][my];
                grid[mx][my] = tmp;
            }

            turnCnt++;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}