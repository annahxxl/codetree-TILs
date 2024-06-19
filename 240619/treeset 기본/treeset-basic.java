import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Integer> ts = new TreeSet<>();

        for(int i = 0; i < n; i++) {
            String op = sc.next();

            if(op.equals("add")) {
                int v = sc.nextInt();
                ts.add(v);
            }

            if(op.equals("remove")) {
                int v = sc.nextInt();
                ts.remove(v);
            }

            if(op.equals("find")) {
                int v = sc.nextInt();
                System.out.println(ts.contains(v));
            }

            if(op.equals("lower_bound")) {
                int v = sc.nextInt();
                System.out.println(ts.ceiling(v) != null ? ts.ceiling(v) : "None");
            }

            if(op.equals("upper_bound")) {
                int v = sc.nextInt();
                System.out.println(ts.higher(v) != null ? ts.higher(v) : "None");
            }

            if(op.equals("largest")) {
                System.out.println(ts.size() > 0 ? ts.last() : "None");
            }

            if(op.equals("smallest")) {
                System.out.println(ts.size() > 0 ? ts.first() : "None");
            }
        }
    }
}