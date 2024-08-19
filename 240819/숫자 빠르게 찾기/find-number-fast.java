import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < m; i ++) {
            int target = sc.nextInt();

            int l = 0;
            int r = n - 1;
            int answer = -1;

            while(l <= r) {
                int mid = (l + r) / 2;

                if(arr[mid] == target) {
                    answer = mid + 1;
                    break;
                }

                if(arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            System.out.println(answer);
        }
    }
}