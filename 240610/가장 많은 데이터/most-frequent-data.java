import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        
        int answer = 0;

        for(int i = 0; i < n; i++) {
            String k = sc.next();
            map.put(k, map.getOrDefault(k, 0) + 1);
            answer = Math.max(answer, map.get(k));
        }

        System.out.println(answer);
    }
}