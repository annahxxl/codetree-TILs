import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int[][] grid = new int[n][n];

        for(int i = 0; i < n; i++) 
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int[][] dir = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        Queue<int[]> q = new LinkedList<>();
        int cr = r;
        int cc = c;
        q.add(new int[] {cr, cc});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            cr = cur[0];
            cc = cur[1];
            System.out.print(grid[cr][cc] + " ");

            int max = grid[cr][cc];
            
            for(int i = 0; i < dir.length; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] > max) {
                    cr = nr;
                    cc = nc;
                    q.add(new int[] {cr, cc});
                    break;
                }
            }
        }
    }
}