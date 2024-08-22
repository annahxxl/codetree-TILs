import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int minCnt = m;
        int maxCnt = -1;

        for(int target = a; target <= b; target++) {
            int l = 1, r = m;
            int cnt = 0;

            while(l <= r) {
                cnt++;
                int mid = (l + r) / 2;

                if(mid == target) {
                    minCnt = Math.min(minCnt, cnt);
                    maxCnt = Math.max(maxCnt, cnt);
                }

                if(mid > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        System.out.print(minCnt + " " + maxCnt);
    }
}