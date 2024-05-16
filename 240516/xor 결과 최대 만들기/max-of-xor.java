import java.util.*;

public class Main {
    static int n, m, answer;
    static int[] nums;
    static ArrayList<Integer> result;

    static void xor() {
        int total = 0;
        for(int r : result) total = total ^ r;
        answer = Math.max(answer, total);
    }
    
    static void dfs(int idx) {
        if(result.size() == m) {
            xor();
            return;
        }

        if(idx == n) return;

        dfs(idx + 1);
        result.add(nums[idx]);
        dfs(idx + 1);
        result.remove(result.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        result = new ArrayList<>();

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        dfs(0);

        System.out.println(answer);
    }
}