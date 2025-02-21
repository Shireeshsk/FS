import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieMarathon {
    public static int helper(int arr[],int rest[],int size){
        int l = 0,r = size-1,max = 0;
        while(r<arr.length-1){
            int sum = 0;
            boolean isValid = true;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = l;i<=r;i++){
                for(int j:rest){
                    if(arr[i]==j){
                        isValid = false;
                        l=i+1;
                        r = l+size-1;
                        break;
                    }
                }
                if(!isValid) break;
                if(map.containsKey(arr[i])){
                    int idx = map.get(arr[i]);
                    l = idx +1;
                    r = size-1+l;
                    break;
                }
                map.put(arr[i],i);
                sum+=arr[i];
            }
            if(isValid){
                max = Math.max(max,sum);
            }
            l++;
            r++;
        }
        return max==0?-1:max;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int rest[] = new int[m];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0;i<m;i++){
            rest[i] = sc.nextInt();
        }
        System.out.println(helper(arr,rest,k));
    }
}
