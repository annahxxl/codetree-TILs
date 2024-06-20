import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k = 1;
    static int[][] map;
    static int[][] visited;
    static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    static void dfs(int x, int y) {
        for(int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > k) {
                visited[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();

        int maxK = k;
        int maxCnt = 0;

        while(true) {
            visited = new int[n][m];
            int cnt = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visited[i][j] == 0 && map[i][j] > k) {
                        visited[i][j] = 1;
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            if(cnt == 0) break;

            if(cnt > maxCnt) {
                maxCnt = cnt;
                maxK = k;
            }

            k++;
        }

        System.out.println(maxK + " " + maxCnt);
    }
}