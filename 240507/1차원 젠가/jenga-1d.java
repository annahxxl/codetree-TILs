import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] block = new int[n];

        for(int i = 0; i < n; i++)
            block[i] = sc.nextInt();

        int[] tmp = new int[n];
        int idx = 0;

        for(int i = 0; i < 2; i++) {
            int s = sc.nextInt() - 1, e = sc.nextInt() - 1;

            for(int j = 0; j < block.length; j++) {
                if(j < s || j > e) {
                    tmp[idx] = block[j];
                    idx++;
                }
            }

            block = new int[idx];

            for(int j = 0; j < idx; j++) {
                block[j] = tmp[j];
            }

            idx = 0;
        }

        System.out.println(block.length);
        for(int i = 0; i < block.length; i++)
            System.out.println(block[i]);
    }
}