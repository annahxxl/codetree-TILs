import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] cnt = new int[n][n];
        int[][] ncnt = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            cnt[r][c] += 1;
        }

        int[][] dir = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
    ///

        for(int ct = 0; ct < t; ct++) {

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(cnt[i][j] == 1) {
                        int max = 0, mr = 0, mc = 0;

                        for(int k = 0; k < dir.length; k++) {
                            int nr = i + dir[k][0];
                            int nc = j + dir[k][1];

                            if(nr >= 0 && nr < n && nc >= 0 && nc < n && max < grid[nr][nc]) {
                                max = grid[nr][nc];
                                mr = nr;
                                mc = nc;
                            }
                        }

                        ncnt[mr][mc]++;
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(ncnt[i][j] == 1) {
                        cnt[i][j] = 1;
                    } else {
                        cnt[i][j] = 0;
                    }
                }
            }
        }
        
        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(ncnt[i][j] == 1)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}