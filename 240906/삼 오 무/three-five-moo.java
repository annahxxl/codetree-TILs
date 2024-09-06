import java.util.Scanner;

public class Main {

    static int getOrder(int num) {
        return num - (num / 3) - (num / 5) + (num / 15);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int l = 1;
        int r = 1000000000;

        while(l <= r) {
            int mid = (l + r) / 2;
            int order = getOrder(mid);

            if(order == n) {
                System.out.println(mid);
            }

            if(order > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
    }
}