import java.util.*;
public class FindDistance{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
     public static Node BuildTree(int arr[]){
        if(arr.length==0){
            return null;
        }
        int idx = 0;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[idx++]);
        if(arr.length==1){
            return root;
        }
        q.add(root);
        while(arr.length>idx){
            Node sk = q.remove();
            if(arr[idx]!=-1){
                sk.left = new Node(arr[idx]);
                q.add(sk.left);
            }
            idx++;
            if(idx>=arr.length) break;
            if(arr[idx]!=-1){
                sk.right = new Node(arr[idx]);
                q.add(sk.right);
            }
            idx++;
        }
        return root;
    }
    
    public static Node CommonAnc(Node root,int n1,int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node left = CommonAnc(root.left,n1,n2);
        Node right = CommonAnc(root.right,n1,n2);
        if(left!=null && right !=null){
            return root;
        }
        return left==null?right:left;
    }
    
    public static int caldist(Node root,int val,int dist){
        if(root == null){
            return -1;
        }
        if(root.data == val){
            return dist;
        }
        int left = caldist(root.left,val,dist+1);
        if(left!=-1){
            return left;
        }
        return caldist(root.right,val,dist+1);
    }
    
    public static int distance(int n1,int n2,Node root){
        if(root == null){
            return 0;
        }
        Node anc = CommonAnc(root,n1,n2);
        int dist1 = caldist(anc,n1,0);
        int dist2 = caldist(anc,n2,0);
        return dist1+dist2;
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for(int i = 0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Node root = BuildTree(arr);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(distance(n1,n2,root));
        sc.close();
    }
}
