import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();

        long l = 1, r = 2000000000;
        long answer = -1;

        while(l <= r) {
            long mid = (l + r) / 2;

            if(mid * (mid + 1) / 2 <= s) {
                l = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }
}