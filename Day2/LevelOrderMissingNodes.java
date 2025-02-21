import java.util.*;

public class LevelOrderMissingNodes {
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
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[idx++]);
        q.add(root);
        while(idx<arr.length){
            Node temp = q.remove();
            if(idx<arr.length){
                if(arr[idx]==-1){
                    temp.left = null;
                    idx++;
                }
                else{
                    temp.left = new Node(arr[idx++]);
                    q.add(temp.left);
                }
            } 
            if(idx<arr.length){
                if(arr[idx]==-1){
                    temp.right = null;
                    idx++;
                }
                else{
                    temp.right = new Node(arr[idx++]);
                    q.add(temp.right);
                }
            }
        }
        return root;
    }

    public static void InOrder(Node root){
        if(root==null){
            return ;
        }
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String sk = sc.nextLine();
        String[] temp = sk.split(" ");
        int arr[] = new int[temp.length];
        for(int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        Node root = buildTree(arr);
        InOrder(root);
        sc.close();
    }
}
