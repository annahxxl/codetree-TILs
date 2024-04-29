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
        int[] cnt = new int[5];

        for (int i = 0; i < n; i++) {
            cnt[result[i]]++;
        }

        for (int i = 1; i < 5; i++) {
            if (cnt[i] % i != 0) return false;
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