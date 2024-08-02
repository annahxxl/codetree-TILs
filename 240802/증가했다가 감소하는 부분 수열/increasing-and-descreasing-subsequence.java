import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int[] idp = new int[n]; // 증가하고 있는 수열
        int[] iddp = new int[n]; // 감소하고 있는 수열 or 감소하게 될 수열
        for(int i = 0; i < n; i++) {
            idp[i] = 1;
            iddp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i])
                    idp[i] = Math.max(idp[i], idp[j] + 1);
                
                if(nums[j] > nums[i])
                    iddp[i] = Math.max(iddp[i], iddp[j] + 1);
            }

            // 감소하게 될 수열(증가수열)과 감소하고 있는 수열 중 최댓값
            iddp[i] = Math.max(idp[i], iddp[i]);   
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) 
            answer = Math.max(answer, Math.max(idp[i], iddp[i]));
        
        System.out.println(answer);
    }
}