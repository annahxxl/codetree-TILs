import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static ArrayList<Integer> res = new ArrayList<>();
    static int answer = 0;

    static void dfs() {
        if(res.size() == n) {
            int total = 0;
            for(int i = 0; i < n; i++) {
                int op = res.get(i);
                if(op == 1) {
                    total += nums[i];
                } else {
                    total -= nums[i];
                }
            }

            if(total < -20 || total > 20) return;
            if(total == m) answer++;
            return;
        }

        for(int i = 0; i <= 1; i++) {
            res.add(i);
            dfs();
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        if(n == 1) {
            if(n == Math.abs(m)) {
                System.out.println(1);
                return;
            }
        }
        dfs();
        System.out.println(answer);
    }
}