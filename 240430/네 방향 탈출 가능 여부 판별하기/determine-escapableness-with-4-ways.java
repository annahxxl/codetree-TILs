import java.util.*;

public class Main {
    static int n, m, answer;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    static void bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for (int i = 0; i < dir.length; i++) {
                int[] d = dir[i];
                int nx = x + d[0], ny = y + d[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
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

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        bfs();

        System.out.println(visited[n - 1][m - 1] == true ? 1 : 0);
    }
}