import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] dir = { {0, 1}, {1, 0} };

    static void dfs(int x, int y) {
        for (int i = 0; i < dir.length; i++) {
            int[] d = dir[i];
            int nx = x + d[0], ny = y + d[1];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && visited[nx][ny] == false) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        visited[0][0] = true;

        dfs(0, 0);

        System.out.println(visited[n - 1][m - 1] == true ? 1 : 0);
    }
}