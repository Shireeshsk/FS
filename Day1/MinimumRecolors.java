import java.util.*;

public class MinimumRecolors {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        System.out.println(helper(str, n));
        sc.close();
    }

    public static int helper(String str,int num){
        if(str.length()==0){
            return 0;
        }
        int minrepairs = Integer.MAX_VALUE;
        for(int i =0;i<=str.length()-num;i++){
            int repairs = 0;
            for(int j = i;j<i+num;j++){
                if(str.charAt(j)=='R'){
                    repairs++;
                }
            }
            minrepairs = Math.min(repairs,minrepairs);
        }
        return minrepairs;
    }
}
