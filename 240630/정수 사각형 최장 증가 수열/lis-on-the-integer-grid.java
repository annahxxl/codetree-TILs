import java.util.*;

class Cell implements Comparable<Cell> {
    int v, x, y;

    public Cell(int v, int x, int y) {
        this.v = v;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Cell cell) {
        return this.v - cell.v;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        ArrayList<Cell> cells = new ArrayList<>();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                cells.add(new Cell(grid[i][j], i, j));
        Collections.sort(cells);

        int[][] dp = new int[n][n]; // 각 칸에 대해 4개의 인접 방향만 체크하면 됨
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = 1;
        int[][] dir = new int[][] { {0, -1}, {-1, 0}, {0, 1}, {1, 0} };

        for(int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            int x = cell.x;
            int y = cell.y;
            
            for(int j = 0; j < dir.length; j++) {
                int nx = x + dir[j][0];
                int ny = y + dir[j][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] > grid[x][y]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                answer = Math.max(answer, dp[i][j]);

        System.out.print(answer);
    }
}