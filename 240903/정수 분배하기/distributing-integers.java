import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] nums;

    static boolean isPossible(int max) {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] < max)
                return false;
            
            cnt += (nums[i] / max);
        }

        return cnt >= m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        
        int ans = 0;
        int l = 1;
        int r = 100000;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(isPossible(mid)) {
                l = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                r = mid - 1;
            }
        }
        
        System.out.println(ans);
    }
}