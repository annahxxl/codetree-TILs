import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            int k = sc.nextInt();
            TreeSet<Integer> ts = new TreeSet<>();

            for(int i = 0; i < k; i++) {
                String op = sc.next();
                int n = sc.nextInt();
                if(op.equals("I")) ts.add(n);
                if(op.equals("D")) {
                    if(!ts.isEmpty()) {
                        if(n == 1) ts.remove(ts.last());
                        if(n == -1) ts.remove(ts.first());
                    }
                }
            }

            if(ts.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(ts.last() + " " + ts.first());
            }
        }
    }
}