import java.util.*;

public class Main {
    static int n;
    static int[][] grid;

    static int cnt;
    static int[][] visited;
    static int[][] dir = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static void dfs(int x, int y) {
        for(int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1 && visited[nx][ny] == 0) {
                cnt++;
                visited[nx][ny] = 1;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        visited = new int[n][n];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    cnt = 1;
                    visited[i][j] = 1;
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
}