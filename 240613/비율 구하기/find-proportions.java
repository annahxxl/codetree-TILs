import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> m = new TreeMap<>();
        int total = 0;

        for(int i = 0; i < n; i++) {
            String k = sc.next();
            m.put(k, m.getOrDefault(k, 0) + 1);
            total++;
        }

        for(Map.Entry<String, Integer> e : m.entrySet()) {
            double p = (e.getValue() * 100.0) / total;
            String fp = String.format("%.4f", p);
            System.out.println(e.getKey() + " " + fp);
        }
    }
}