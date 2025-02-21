import java.util.*;

public class LongestViableSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int freq = sc.nextInt();
        int area = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(viableSet(arr, freq, area));
        sc.close();
    }

    public static int viableSet(int arr[],int freq,int maxarea){
        int l = 0,area = 0,maxlen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int r = 0;r<arr.length;r++){
            boolean flag = true;
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            for(int i:map.values()){
                if(i>freq){
                    flag = false;
                    break;
                }
            }
            if(flag){
                area += arr[r];
            }
            else{
                map.put(arr[r],map.get(arr[r])-1);
                if(map.get(arr[r])==0){
                    map.remove(arr[r]);
                }
                continue;
            }
            while(area>maxarea){
                area -= arr[l];
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}
