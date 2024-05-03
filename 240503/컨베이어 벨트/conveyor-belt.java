import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] u = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++)
            u[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            d[i] = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int tmp = u[n - 1];

            for(int j = n - 1; j > 0; j--) 
                u[j] = u[j - 1];
            u[0] = d[n - 1];

            for(int j = n - 1; j > 0; j--)
                d[j] = d[j - 1];
            d[0] = tmp;
        }

        for(int i = 0; i < n; i++)
            System.out.print(u[i] + " ");
        System.out.println();
        for(int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
    }
}