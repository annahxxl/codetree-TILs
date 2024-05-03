import java.util.Scanner;

public class Main {
    static int n, m, k, answer;
    static int[] turn;
    static int[] status; // idx = 말, value = 움직인 칸

    static void dfs(int turnCnt) {
        if (turnCnt == n) {
            int goalCnt = 0;
            for(int i = 0; i < k; i++) {
                if(status[i] >= m) goalCnt++;
            }
            answer = Math.max(answer, goalCnt);
            return;
        }

        for(int i = 0; i < k; i++) {
            status[i] += turn[turnCnt];
            dfs(turnCnt + 1);
            status[i] -= turn[turnCnt];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        turn = new int[n];
        status = new int[k];
        for(int i = 0; i < n; i++) turn[i] = sc.nextInt();
        for(int i = 0; i < k; i++) status[i] = 1;

        dfs(0);

        System.out.println(answer);
    }
}