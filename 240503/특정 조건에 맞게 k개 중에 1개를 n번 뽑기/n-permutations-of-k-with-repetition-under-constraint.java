import java.util.*;

public class Main {
    static int k, n;
    static ArrayList<Integer> result = new ArrayList<>();

    static boolean check(int num) {
        int resultSize = result.size();
        return !(result.get(resultSize - 1) == num && result.get(resultSize - 2) == num);
    }

    static void dfs(int depth) {
        if(depth == n) {
            for(int i = 0; i < n; i++)
                System.out.print(result.get(i) + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= k; i++) {
            if(result.size() < 2 || check(i)) {
                result.add(i);
                dfs(depth + 1);
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        dfs(0);
    }
}