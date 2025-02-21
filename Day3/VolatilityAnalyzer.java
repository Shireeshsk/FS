import java.util.*;
public class VolatilityAnalyzer{
    public static int calculator(int arr[],int num){
        int l = 0;
        int r = num-1;
        int vol = Integer.MIN_VALUE;
        while(r<arr.length){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = l;i<=r;i++){
                min = Math.min(min,arr[i]);
                max = Math.max(max,arr[i]);
            }
            vol = Math.max(vol,max-min);
            l++;
            r++;
        }
        return vol;
    }

    public static int optimal(int arr[],int num){
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int l = 0,r = num-1,vol = Integer.MIN_VALUE;
        for(int i = 0;i<=r;i++){
            min.add(arr[i]);
            max.add(arr[i]);
        }
        vol = Math.max(vol,max.peek()-min.peek());
        while(r<arr.length-1){
            min.remove(arr[l]);
            max.remove(arr[l]);
            l++;
            r++;
            min.add(arr[r]);
            max.add(arr[r]);
            vol = Math.max(vol,max.peek()-min.peek());
        }
        return vol;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(calculator(arr, r));
        System.out.println(optimal(arr, r));
        sc.close();
    }
}