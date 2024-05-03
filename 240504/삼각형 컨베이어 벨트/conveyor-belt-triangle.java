import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        for(int i = 0; i < n; i++) b[i] = sc.nextInt();
        for(int i = 0; i < n; i++) c[i] = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int tmp1 = a[n - 1];
            int tmp2 = b[n - 1];
            int tmp3 = c[n - 1];
            
            for(int j = n - 1; j > 0; j--) a[j] = a[j - 1];
            for(int j = n - 1; j > 0; j--) b[j] = b[j - 1];
            for(int j = n - 1; j > 0; j--) c[j] = c[j - 1];

            a[0] = tmp3;
            b[0] = tmp1;
            c[0] = tmp2;
        }

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }
}