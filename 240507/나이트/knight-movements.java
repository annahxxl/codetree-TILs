import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(),c2 = sc.nextInt();

        if(r1 == r2 && c1 == c2) {
            System.out.println(0);
            return;
        }

        int[][] step = new int[n + 1][n + 1];
        boolean[][] visited = new boolean[n + 1][n + 1];
        int[][] dir = new int[][] { {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2} };
        Queue<int[]> q = new LinkedList<>();

        visited[r1][c1] = true;
        q.add(new int[] {r1, c1});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for(int i = 0; i < dir.length; i++) {
                int nr = r + dir[i][0], nc = c + dir[i][1];

                if(nr >= 1 && nr <= n && nc >= 1 && nc <= n && visited[nr][nc] == false) {
                    step[nr][nc] = step[r][c] + 1;
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
        
        System.out.println(step[r2][c2] == 0 ? -1 : step[r2][c2]);
    }
}