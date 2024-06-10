import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int k = sc.nextInt();
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        for(int i = 0; i < m; i++) {
            int k = sc.nextInt();
            System.out.print(map.getOrDefault(k, 0) + " ");
        }
    }
}