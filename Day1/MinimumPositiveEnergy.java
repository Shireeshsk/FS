import java.util.*;
public class MinimumPositiveEnergy{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr,l,r));
        sc.close();
    }

    public static int helper(int arr[],int l ,int r){
        int min = Integer.MAX_VALUE;
        for(int i = l;i<=r;i++){
            min = Math.min(min,MinPE(arr,i));
        }
        return min;
    }

    public static int MinPE(int arr[],int num){
        int l = 0;
        int r = num-1;
        int prod = 1;
        for(int i=0;i<=r;i++){
            prod *= arr[i];
        }
        int min = Integer.MAX_VALUE;
        if(prod>0){
            min = Math.min(min,prod);
        }
        while(r<arr.length-1){
            prod /= arr[l];
            l++;
            r++;
            prod *= arr[r];
            if(prod>0){
                min = Math.min(min,prod);
            }
        }
        return min;
    }
}