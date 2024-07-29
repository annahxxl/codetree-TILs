import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        TreeSet<Integer> s = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            s.add(num);
        }

        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if(s.ceiling(num) == null) {
                System.out.println(-1);
            } else {
                System.out.println(s.ceiling(num));
            }
        }
    }
}