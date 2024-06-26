import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> m = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            String k = sc.next();
            m.put(k, m.getOrDefault(k, 0) + 1);
        }

        for(Map.Entry<String, Integer> e : m.entrySet()) {
            double ratio = (double) e.getValue() * 100 / n;
            System.out.printf("%s %.4f\n", e.getKey(), ratio);
        }
    }
}