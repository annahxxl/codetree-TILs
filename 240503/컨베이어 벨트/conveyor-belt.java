import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] u = int[n];
        int[] d = int[n];

        for(int i = 0; i < n; i++)
            u[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int tmp = u[n - 1];

            for(int i = n - 1; i > 0; i--) 
                u[i] = u[i - 1];
            u[0] = d[n - 1];

            for(int i = n - 1; i > 0; i--)
                d[i] = d[i - 1];
            d[0] = tmp;
        }

        for(int i = 0; i < n; i++)
            System.out.print(u[i] + " ");
        System.out.println();
        for(int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
    }
}