import java.util.*;

public class Main {
    static int n;
    static int k;
    static int m;
    static int[][] grid;
    static ArrayList<int[]> starts = new ArrayList<>();
    static ArrayList<int[]> stones = new ArrayList<>();
    static ArrayList<int[]> combs = new ArrayList<>();

    static void createCombs(int start, int count, int[] selected) {
        if (count == m) {
            combs.add(selected.clone());
            return;
        }

        for (int i = start; i < stones.size(); i++) {
            selected[count] = i;
            createCombs(i + 1, count + 1, selected);
        }
    }

    static int[][] createMap(int[] comb) {
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = grid[i][j];
        
        for (int idx : comb) {
            int[] stone = stones.get(idx);
            int r = stone[0];
            int c = stone[1];
            map[r][c] = 0;
        }

        return map;
    }

    static int bfs(int[][] map, int[] start, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dir = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

        int r = start[0];
        int c = start[1];
        q.add(new int[] {r, c});
        visited[r][c] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dir) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0 && !visited[nx][ny]) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    stones.add(new int[] {i, j});
                }
            }
        }
        
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            starts.add(new int[] {r, c});
        }

        createCombs(0, 0, new int[m]);

        int answer = 0;

        for (int[] comb : combs) {
            int[][] map = createMap(comb);
            boolean[][] visited = new boolean[n][n];
            int totalReachable = 0;

            for (int[] start : starts) {
                if (!visited[start[0]][start[1]]) {
                    totalReachable += bfs(map, start, visited);
                }
            }

            answer = Math.max(answer, totalReachable);
        }

        System.out.println(answer);
    }
}