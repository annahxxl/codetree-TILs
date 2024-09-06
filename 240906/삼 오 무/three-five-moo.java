import java.util.Scanner;

public class Main {

    static long getOrder(long num) {
        return num - (num / 3) - (num / 5) + (num / 15);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        long l = 1;
        long r = Integer.MAX_VALUE;
        long ans = -1;

        while(l <= r) {
            long mid = (l + r) / 2;
            long order = getOrder(mid);

            if(order == n) {
                ans = mid;
                r = mid - 1;
            } else if(order > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
}