import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int mv = -1;
        int mx = x - 1;
        int my = y - 1;
        int ax = mx;
        int ay = my;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][n];
        int[][] dir = new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };

        q.add(new int[] {mx, my});
        visited[mx][my] = 1;

        for(int i = 0; i < k; i++) {
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];

                for(int j = 0; j < dir.length; j++) {
                    int nx = cx + dir[j][0];
                    int ny = cy + dir[j][1];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0 && grid[ax][ay] > grid[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = 1;

                        if(mv < grid[nx][ny]) {
                            mv = grid[nx][ny];
                            mx = nx;
                            my = ny;
                        } else if(mv == grid[nx][ny]) {
                            if(mx > nx || (mx == nx && my > ny)) {
                                mx = nx;
                                my = ny;
                            }
                        }
                    }
                }
            }

            visited = new int[n][n];

            q.add(new int[] {mx, my});
            visited[mx][my] = 1;

            ax = mx;
            ay = my;
            mv = -1;
        }

        System.out.println((ax + 1) + " " + (ay + 1));   
    }
}