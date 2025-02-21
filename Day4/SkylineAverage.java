import java.util.*;
public class SkylineAverage{
    public static int[] helper(int arr[],int mask[],int k){
        int l = k;
        int res[] = new int[arr.length];
        Arrays.fill(res,-1);
        while(l<=arr.length-1-k){
            int sum = 0;
            int num = 0;
            for(int i = l-k;i<=l+k;i++){
                if(mask[i]==1){
                    sum += arr[i];
                    num++;
                }
            }
            res[l++] = (sum/num);
        }
        return res;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int mask[] = new int[n];
        for(int i = 0;i<n;i++){
            mask[i] = sc.nextInt();
        }
        int res[] = helper(arr, mask, k);
        for(int i = 0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        sc.close();
    }
}