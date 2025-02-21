import java.util.*;
public class RightView{
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
        while(idx<arr.length){
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

    public static List<Integer> rightView(Node root){
        Queue<Node> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int num = 0;
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node sk = q.remove();
                num = sk.data;
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
        System.out.println(rightView(root));
        sc.close();
    }
}
