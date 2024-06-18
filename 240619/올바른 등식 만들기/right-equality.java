import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] nums;
    static ArrayList<Integer> res = new ArrayList<>();
    static int answer = 0;

    static void dfs() {
        if(res.size() == n - 1) {
            int total = nums[0];
            for(int i = 1; i < n; i++) {
                int op = res.get(i - 1);
                if(op == 1) {
                    total += nums[i];
                } else {
                    total -= nums[i];
                }
            }

            if(total < -20 || total > 20) return;
            answer++;
            return;
        }

        res.add(1);
        dfs();
        res.remove(res.size() - 1);
        res.add(0);
        dfs();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        dfs();
        System.out.println(answer);
    }
}