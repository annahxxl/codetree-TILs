import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextInt();
        long a = sc.nextInt();
        long b = sc.nextInt();

        long minCnt = m;
        long maxCnt = -1;

        for(long target = a; target <= b; target++) {
            long l = 1, r = m;
            long cnt = 0;

            while(l <= r) {
                cnt++;
                long mid = (l + r) / 2;

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