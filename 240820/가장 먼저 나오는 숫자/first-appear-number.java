import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();

            int l = 0;
            int r = n - 1;
            int minIdx = n;

            while(l <= r) {
                int mid = (l + r) / 2;

                if(arr[mid] == x) {
                    minIdx = Math.min(minIdx, mid);
                }

                if(arr[mid] >= x) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            System.out.println(minIdx == n ? -1 : minIdx + 1);
        }
    }
}