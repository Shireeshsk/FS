import java.util.*;
public class TreasureVault {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();
        int F = sc.nextInt();
        int arr[] = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr, K, X, F));
        sc.close();
    }
    
    public static List<Integer> helper(int arr[],int K,int X,int F){
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int r = K-1;
        while(r<arr.length){
            Map<Integer,Integer> map = new HashMap<>();
            for(int i =l;i<=r;i++){
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            List<int[]> list = new ArrayList<>();
            for(Map.Entry<Integer,Integer> sk:map.entrySet()){
                int key = sk.getKey();
                int val = sk.getValue();
                int cal = val * (int)(Math.pow(key,F));
                list.add(new int[]{key,cal,val});
            }

            Collections.sort(list,new Comparator<int[]>() {
                @Override
                public int compare(int[] a , int[] b){
                    if(a[1]==b[1]){
                        return b[0]-a[0];
                    }
                    else{
                        return b[1]-a[1];
                    }
                }
            });
            System.out.println("Elements taken : ");
            int sum = 0;
            for(int i =0;i<Math.min(X,list.size());i++){
                int sk[]= list.get(i);
                System.out.print(sk[0]+ " ");
                sum += sk[0]*sk[2];
            }
            System.out.println();
            System.out.println("total : "+sum);
            res.add(sum);
            l++;
            r++;
        }
        return res;
    }
}
