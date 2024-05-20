import java.util.*;

public class Main {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();;

    static void dfs() {
        if(result.size() == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = n; i >= 1; i--) {
            if(visited[i] == false) {
                visited[i] = true;
                result.add(i);
                dfs();
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        dfs();
    }
}