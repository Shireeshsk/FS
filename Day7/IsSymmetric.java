import java.util.*;
public class IsSymmetric{
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
    
    public static boolean isSymmetric(Node l,Node r){
        if(l==null && r==null){
            return true;
        }
        if(l==null || r==null){
            return false;
        }
        if(l.data!=r.data){
            return false;
        }
        return isSymmetric(l.left,r.right) && isSymmetric(l.right,r.left);
    }
    
    public static boolean isSymmetric(Node root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for(int i = 0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Node root = BuildTree(arr);
        System.out.println(isSymmetric(root));
        sc.close();
    }

}