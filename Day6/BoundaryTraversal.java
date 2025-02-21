import java.util.*;
public class BoundaryTraversal {
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

    public static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }

    public static void leftBoundary(Node root,List<Integer> res){
        Node curr = root;
        while(curr!=null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            if(curr.left!=null){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
    }

    public static void rightBoundary(Node root,List<Integer> res){
        Node curr = root;
        List<Integer> temp = new ArrayList<>();
        while(curr!=null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right!=null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }

        for(int i = temp.size()-1;i>=0;i--){
            res.add(temp.get(i));
        }
    }

    public static void leafTraverse(Node root,List<Integer> res){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left!=null){
            leafTraverse(root.left, res);
        }
        if(root.right!=null){
            leafTraverse(root.right, res);
        }
    }

    public static List<Integer> boundaryTraversal(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        if(!isLeaf(root)){
            res.add(root.data);
        }
        leftBoundary(root.left, res);
        leafTraverse(root, res);
        rightBoundary(root.right, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for(int i = 0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Node root = BuildTree(arr);
        System.out.println(boundaryTraversal(root));
        sc.close();
    }
}
