import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            String op = sc.next();

            if(op.equals("add")) {
                int v = sc.nextInt();
                set.add(v);
            }

            if(op.equals("remove")) {
                int v = sc.nextInt();
                set.remove(v);
            }

            if(op.equals("find")) {
                int v = sc.nextInt();
                System.out.println(set.contains(v));
            }
        }
    }
}