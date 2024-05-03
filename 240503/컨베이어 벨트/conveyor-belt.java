import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[][] arr = new int[2][n];

        for (int i = 0; i < n; i++) {
            arr[0][i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[1][i] = sc.nextInt();
        }


        for (int i = 0; i < t; i++) {
            int tmp1 = arr[0][n - 1];
            for (int j = n - 1; j > 0; j--) {
                arr[0][j] = arr[0][j - 1];
            }

            int tmp2 = arr[1][0];
            for (int j = 0; j < n - 1; j++) {
                arr[1][j] = arr[1][j + 1];
            }

            arr[0][0] = tmp2;
            arr[1][n - 1] = tmp1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[0][i] + " ");
        }
        System.out.println();
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[1][i] + " ");
        }
    }
}