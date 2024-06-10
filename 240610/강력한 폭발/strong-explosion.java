import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static int bombCnt = 0;
    static int[][][] bombTypes = new int[][][] {
        { {-2, 0}, {-1, 0}, {1, 0}, {2, 0} },
        { {-1, 0}, {0, -1}, {0, 1}, {1, 0} },
        { {-1, -1}, {-1, 1}, {1, -1}, {1, 1} },
    };
    static ArrayList<Integer> bombResult = new ArrayList<>(); // 유형 조합
    static int answer = 0;

    static private void dfs() {
        if(bombResult.size() == bombCnt) {
            int[][] visited = new int[n][n];
            int cnt = 0;
            int idx = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) {
                        if(visited[i][j] == 0) {
                            cnt++;
                            visited[i][j] = 1;
                        }

                        int[][] bombType = bombTypes[bombResult.get(idx)];

                        for(int k = 0; k < 4; k++) {
                            int nx = i + bombType[k][0];
                            int ny = j + bombType[k][1];
                            
                            if(nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0) {
                                cnt++;
                                visited[nx][ny] = 1;
                            }
                        }

                        idx++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for(int i = 0; i < bombTypes.length; i++) {
            bombResult.add(i);
            dfs();
            bombResult.remove(bombResult.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];  
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < n; j++) 
                if(grid[i][j] == 1) bombCnt++;

        dfs();
        System.out.println(answer);
    }
}