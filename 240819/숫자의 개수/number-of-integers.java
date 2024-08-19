import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;

    static int calcLowerBound(int target) {
        int l = 0;
        int r = n - 1;
        int lb = n;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid] >= target) {
                r = mid - 1;
                lb = Math.min(lb, mid);
            } else {
                l = mid + 1;
            }
        }

        return lb;
    }

    static int calcUpperBound(int target) {
        int l = 0;
        int r = n - 1;

        int ub = n; // upper bound
        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid] > target) {
                r = mid - 1;
                ub = Math.min(ub, mid);
            } else {
                l = mid + 1;
            }
        }

        return ub;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        n = N;
        
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            int target = sc.nextInt();
            int lb = calcLowerBound(target);
            int ub = calcUpperBound(target);
            System.out.println(ub - lb);
        }
    }
}