import java.util.*;

public class Main {
    static int n, m, answer;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int v) {
        for (int i = 0; i < graph[v].size(); i++) {
            int cur = graph[v].get(i);
            if (!visited[cur]) {
                visited[cur] = true;
                answer++;
                dfs(cur);;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];

        visited[1] = true;
        dfs(1);

        System.out.println(answer);
    }
}