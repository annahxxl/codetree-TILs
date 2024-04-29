import java.util.*;

public class Main {
    static int n, answer;
    static int[] result;

    static void dfs(int depth) {
        if (depth == n) {
            if (check()) {
                answer++;
            }
            return;
        }

        for (int i = 1; i < 5; i++) {
            result[depth] = i;
            dfs(depth + 1);
            result[depth] = 0;
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i += result[i]) {
            if (i + result[i] - 1 >= n) return false;

            for (int j = i; j < i + result[i]; j++) {
                if (result[j] != result[i]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        result = new int[n];

        dfs(0);
        System.out.println(answer);
    }
}