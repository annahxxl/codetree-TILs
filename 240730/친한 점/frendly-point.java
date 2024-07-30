import java.util.*;

class Dot implements Comparable<Dot> {
    int x, y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot d) {
        if(this.x != d.x) 
            return this.x - d.x;
        else
            return this.y - d.y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Dot> dots = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dots.add(new Dot(x, y));
        }

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Dot nearBy = dots.ceiling(new Dot(x, y));
            if(nearBy == null) {
                System.out.println("-1 -1");
            } else {
                System.out.println(nearBy.x + " " + nearBy.y);
            }
        }
    }
}