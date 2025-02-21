import java.util.*;
public class ElixirPotency{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
    }
    public static void helper(int arr[],int num,int nth){
        int k = num;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(k<arr.length){
            int l = 0;
            int r = k-1;
            while(r<arr.length){
                int sum = 0;
                for(int i = l;i<=r;i++){
                    sum += arr[i];
                }
                pq.add(sum);
                l++;
                r++;
            }
            k++;
        }
        
    }
}