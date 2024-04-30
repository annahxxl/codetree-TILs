import java.util.*;

public class Main {
    static int n, k, answer;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    static void bfs() {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            for (int i = 0; i < dir.length; i++) {
                int[] d = dir[i];
                int nx = x + d[0], ny = y + d[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    answer++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            visited[x][y] = true;
            answer++;
            q.offer(new int[]{x, y});
        }

        bfs();

        System.out.println(answer);
    }
}