import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dir = new int[][] { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };
        int[][] step = new int[n][m];

        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < dir.length; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    step[nx][ny] = step[x][y] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        System.out.println(visited[n - 1][m - 1] == true ? step[n - 1][m - 1] : -1);
    }
}