import java.util.*;
public class LeftView {
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
        int idx = 0;
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[idx++]);
        q.add(root);
        while(arr.length>idx){
            Node sk = q.remove();
            if(arr[idx]!=-1){
                sk.left = new Node(arr[idx]);
                q.add(sk.left);
            }
            idx++;
            if(arr.length<=idx) break;
            if(arr[idx]!=-1){
                sk.right = new Node(arr[idx]);
                q.add(sk.right);
            }
            idx++;
        }
        return root;
    }

    public static List<Integer> leftView(Node root){
        List<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int num = 0;
            for(int i = 0;i<size;i++){
                Node sk = q.remove();
                if(i==0){
                    num = sk.data;
                }
                if(sk.left!=null){
                    q.add(sk.left);
                }
                if(sk.right!=null){
                    q.add(sk.right);
                }
            }
            res.add(num);
        }
        return res;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for(int i = 0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Node root = buildTree(arr);
        System.out.println(leftView(root));
        sc.close();
    }
}
