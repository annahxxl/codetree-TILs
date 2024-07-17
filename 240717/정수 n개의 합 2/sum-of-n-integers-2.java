import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();
        
        int[] ps = new int[n + 1];
        for(int i = 1; i <= n; i++)
            ps[i] = ps[i - 1] + arr[i];

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n ; i++) {
            if(i < k) continue;
            answer = Math.max(answer, ps[i] - ps[i - k]);
        }

        System.out.println(answer);
    }
}