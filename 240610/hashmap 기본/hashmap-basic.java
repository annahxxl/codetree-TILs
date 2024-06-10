import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String op = sc.next();

            if(op.equals("add")) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                map.put(k, v);
            } else if(op.equals("remove")) {
                int k = sc.nextInt();
                map.remove(k);
            } else {
                int k = sc.nextInt();
                
                if(map.containsKey(k)) {
                    System.out.println(map.get(k));
                } else {
                    System.out.println("None");
                }
            }
        }
    }
}