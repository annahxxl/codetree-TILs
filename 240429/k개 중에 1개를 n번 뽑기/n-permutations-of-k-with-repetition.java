import java.util.*;

public class Main {
    static int k;
    static int n;
    static ArrayList<Integer> answer = new ArrayList<>();

    static void dfs(int depth) {
        if (depth == n) {
            print();
            return;
        }

        for (int i = 1; i <= k; i++) {
            answer.add(i);
            dfs(depth + 1);
            answer.remove(answer.size() - 1);
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(answer.get(i) + " ");      
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        dfs(0);
    }
}