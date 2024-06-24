import java.util.*;

public class Main {
    static int n;
    static int k;
    static int m;
    static int[][] grid;
    static ArrayList<Integer> res = new ArrayList<>();
    static ArrayList<int[]> starts = new ArrayList<>();
    static ArrayList<int[]> stones = new ArrayList<>();
    static ArrayList<int[]> combs = new ArrayList<>();

    static void createCombs(int s) {
        if(res.size() == m) {
            int[] result = new int[m];
            for(int i = 0; i < res.size(); i++)
                result[i] = res.get(i);
            combs.add(result);
        }

        for(int i = s; i < stones.size(); i++) {
            res.add(i);
            createCombs(i + 1);
        }
    }

    static int[][] createMap(int combIdx) {
        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                map[i][j] = grid[i][j];
        
        int[] comb = combs.get(combIdx);
        for(int i = 0; i < comb.length; i++) {
            int[] stone = stones.get(i);
            int r = stone[0];
            int c = stone[1];
            map[r][c] = 1;
        }

        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    stones.add(new int[] {i, j});
                }
            }
        }
        
        for(int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            starts.add(new int[] {r, c});
        }

        createCombs(0);

        int answer = 0;

        for(int combIdx = 0; combIdx < combs.size(); combIdx++) {
            for(int startIdx = 0; startIdx < starts.size(); startIdx++) {
                int[][] map = createMap(combIdx);
                int[][] visited = new int[n][n];
                Queue<int[]> q = new LinkedList<>();
                int[][] dir = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

                int[] start = starts.get(startIdx);
                int r = start[0];
                int c = start[1];
                q.add(new int[] {r, c});
                visited[r][c] = 1;

                int cnt = 1;

                while(!q.isEmpty()) {
                    int[] cur = q.poll();

                    for(int i = 0; i < dir.length; i++) {
                        int nx = cur[0] + dir[i][0];
                        int ny = cur[1] + dir[i][1];

                        if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                            q.add(new int[] {nx, ny});
                            visited[nx][ny] = 1;
                            cnt++;
                        }
                    }
                    
                }

                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(answer);
    }
}