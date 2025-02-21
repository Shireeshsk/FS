import java.util.*;
public class FlipTree{
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
    
    public static Node buildTree(int arr[]){
        if(arr.length==0){
            return null;
        }
        int idx = 0;
        Node root = new Node(arr[idx++]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(idx<arr.length){
            Node sk = q.remove();
            if(arr[idx]!=-1){
                sk.left=new Node(arr[idx]);
                q.add(sk.left);
            }
            idx++;
            if(arr[idx]!=-1){
                sk.right = new Node(arr[idx]);
                q.add(sk.right);
            }
            idx++;
        }
        return root;
    }
    
    public static Node flipTree(Node root){
        if(root==null || root.left == null) return root;
        Node newRoot = flipTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left=null;
        root.right=null;
        return newRoot;
    }
    public static List<Integer> levelOrder(Node root){
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node sk = q.remove();
            res.add(sk.data);
            if(sk.left!=null) q.add(sk.left);
            if(sk.right != null) q.add(sk.right);
        }
        return res;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for(int i = 0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Node root = buildTree(arr);
        root = flipTree(root);
        System.out.println(levelOrder(root));
        sc.close();
    }
}