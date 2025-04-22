import java.util.*;
public class Solution{
    public static int helper(int arr[]){
        int len = Integer.MAX_VALUE;
        int freq = 0;
        for(int i = 0;i<arr.length;i++){
            for(int j = i;j<arr.length;j++){
                Map<Integer,Integer> map = new HashMap<>();
                for(int k = i;k<=j;k++){
                    map.put(arr[k],map.getOrDefault(arr[k],0)+1);
                    int maxfreq =0;
                    for(int sk : map.values()){
                        if(sk>maxfreq) maxfreq=sk;
                    }
                    if(freq<maxfreq){
                        len = j-i+1;
                        freq = maxfreq;
                    }    
                    else if(freq==maxfreq){
                        len = Math.min(len,j-i+1);
                        freq = maxfreq;
                    }
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int arr[] = {9,8,8,2,4,6};
        System.out.println(helper(arr));
    }
}