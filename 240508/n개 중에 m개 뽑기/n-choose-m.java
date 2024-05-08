import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[] used;

    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= n; i++) {
            if(used[i] == false) {
                result.add(i);
                used[i] = true;
                dfs(depth + 1, i + 1);
                result.remove(result.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        used = new boolean[n + 1];

        dfs(0, 1);
    }   
}