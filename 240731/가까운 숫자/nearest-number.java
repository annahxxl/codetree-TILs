import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            s.add(x);

            Integer lower = s.lower(x);
            Integer higher = s.higher(x);

            int leftDist = (lower != null) ? x - lower : Integer.MAX_VALUE;
            int rightDist = (higher != null) ? higher - x : Integer.MAX_VALUE;

            answer = Math.min(answer, Math.min(leftDist, rightDist));

            System.out.println(answer);
        }
    }
}