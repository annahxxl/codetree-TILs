import java.util.Scanner;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] result;

    static void dfs(int idx) {
        if(idx == n) {
            for(int i = 0; i < n; i++)
                System.out.print(result[i] + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i] == false) {
                result[idx] = i;
                visited[i] = true;
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new boolean[n + 1];
        result = new int[n];

        dfs(0);        
    }
}