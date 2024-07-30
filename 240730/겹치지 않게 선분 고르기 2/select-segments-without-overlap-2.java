import java.util.*;

class Line implements Comparable<Line> {
    int x1, x2;

    public Line(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    } 

    @Override
    public int compareTo(Line l) {
        return this.x1 - l.x1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            lines[i] = new Line(x1, x2);
        }

        int[] dp = new int[n];
        Arrays.sort(lines);

        for(int i = 0; i < n; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                int end = lines[j].x2;
                int start = lines[i].x1;

                if(end < start)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++)
            answer = Math.max(answer, dp[i]);

        System.out.println(answer);
    }
}