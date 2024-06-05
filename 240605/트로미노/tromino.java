import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m;j++)
                grid[i][j] = sc.nextInt();

        int[][][] blocks = new int[][][] {
            { { 1, 0 }, { 1, 1 } },
            { { 1, 0 }, { 0, 1 } },
            { { 0, 1 }, { 1, 1 } },
            { { 0, 1 }, { -1, 1 } },
            { { 0, 1 }, { 0, 2 } },
            { { 1, 0 }, { 2, 0 } },
        };

        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < 6; k++) {
                    int[][] block = blocks[k];
                    int nx1 = i + block[0][0], ny1 = j + block[0][1], nx2 = i + block[1][0], ny2 = j + block[1][1];
                    if(nx1 >= 0 && nx1 < n && ny1 >= 0 && ny1 < m && nx2 >= 0 && nx2 < n && ny2 >= 0 && ny2 < m)
                        answer = Math.max(answer, grid[i][j] + grid[nx1][ny1] + grid[nx2][ny2]);
                }
            }
        }

        System.out.println(answer);
    }
}