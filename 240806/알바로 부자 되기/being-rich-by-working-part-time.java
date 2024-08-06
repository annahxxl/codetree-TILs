import java.util.*;

class PartTimer implements Comparable<PartTimer> {
    int s, e, p;

    PartTimer(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }

    @Override
    public int compareTo(PartTimer pt) {
        return this.s - pt.s;
    }
    
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PartTimer[] pt = new PartTimer[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();
            pt[i] = new PartTimer(s, e, p);
        }
        Arrays.sort(pt);

        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = pt[i].p;

            for(int j = 0; j < i; j++) {
                int e = pt[j].e;
                int s = pt[i].s;
                if(e < s)
                    dp[i] = Math.max(dp[i], dp[j] + pt[i].p);
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++)
            answer = Math.max(answer, dp[i]);

        System.out.println(answer);
    }
}