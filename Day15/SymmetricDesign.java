import java.util.*;
public class SymmetricDesign{
    public static boolean helper(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int count = 0;
        for(int i : map.values()){
            if(s.length()%2==0 && i%2!=0){
                return false; 
            }
            if(s.length()%2!=0 && i%2!=0){
                count++;
            }
        }
        return count<=1;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(helper(s));
        sc.close();
    }
}