import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Integer> s = new TreeSet<>();
        for(int i = 1; i <= m; i++)
            s.add(i);
        
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            s.remove(num);
            System.out.println(s.last());
        }
    }
}