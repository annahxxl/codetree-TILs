import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    static int lb(int target) {
        int l = 0, r = n - 1;
        int minIdx = n;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid] >= target) {
                r = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                l = mid + 1;
            }
        }

        return minIdx;
    }

    static int ub(int target) {
        int l = 0, r = n - 1;
        int minIdx = n;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid] > target) {
                r = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                l = mid + 1;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            System.out.println(ub(e) - lb(s));
        }
    }
}