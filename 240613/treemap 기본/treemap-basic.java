import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> m = new TreeMap<>();

        for(int i = 0; i < n; i++) {
            String op = sc.next();

            if(op.equals("add")) {
                int k = sc.nextInt();
                int v = sc.nextInt();
                m.put(k, v);
            }

            if(op.equals("remove")) {
                int k = sc.nextInt();
                m.remove(k);
            }

            if(op.equals("find")) {
                int k = sc.nextInt();
                if(m.containsKey(k)) {
                    System.out.println(m.get(k));
                } else {
                    System.out.println("None");
                }
            }

            if(op.equals("print_list")) {
                if(m.isEmpty()) {
                    System.out.println("None");
                } else {
                    for(Map.Entry<Integer, Integer> e : m.entrySet()) {
                        System.out.print(e.getValue() + " ");
                    }
                    System.out.println();
                }
            }
        }   
    }
}