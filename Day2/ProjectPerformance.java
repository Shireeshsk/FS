import java.util.*;

public class ProjectPerformance {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int task[] = new int[n];
        int hours[] = new int[n];
        for(int i =0;i<n;i++){
            task[i] = sc.nextInt();
        }
        for(int i =0;i<n;i++){
            hours[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int lower = sc.nextInt();
        int upper = sc.nextInt();
        int work_goal = sc.nextInt();
        System.out.println(point(task,hours,k,lower,upper,work_goal));
        sc.close();
    }
    
    public static int point(int task[],int hours[],int num,int low,int up,int wg){
        int l = 0;
        int r = num-1;
        int T = 0,H = 0;
        int pts = 0;
        for(int i =0;i<=r;i++){
            T += task[i];
            H += hours[i];
        }
        while(r<task.length-1){
            if(T<low){
                if(H>=wg){
                    pts -= 2;
                }
                else{
                    pts -= 1;
                }
            }
            else if(T>=up){
                if(H>=wg){
                    pts += 1;
                }
                else{
                    pts += 2;
                }
            }
            T -= task[l];
            H -= hours[l];
            l++;
            r++;
            T += task[r];
            H += hours[r];
        }
        return pts;
    }
}
