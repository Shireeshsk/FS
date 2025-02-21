import java.util.*;
public class BuildTreeUsingInPost {
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

    public static Node BuildTree(int postorder[],int inorder[]){
        if(postorder==null || inorder==null || postorder.length!=inorder.length){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,inorder,0,inorder.length-1,0,postorder.length-1,map);
    }

    public static Node helper(int postorder[],int inorder[],int ins,int ine,int posts,int poste,Map<Integer,Integer> map){
        if(ins>ine || posts>poste){
            return null;
        }
        Node root = new Node(postorder[poste]);
        int idx = map.get(root.data);
        root.left = helper(postorder,inorder,ins,idx-1,posts,posts+(idx-ins)-1,map);
        root.right = helper(postorder,inorder,idx+1,ine,posts+(idx-ins),poste-1,map);
        return root;
    }

    public static List<Integer> query(int n1,int n2,Node root){
        Queue<Node> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                Node sk = q.remove();
                if(level>=n1 && level<=n2){
                    temp.add(sk.data);
                }
                if(sk.left!=null){
                    q.add(sk.left);
                }
                if(sk.right!=null){
                    q.add(sk.right);
                }
            }
            if(level == n2){
                break;
            }
            level++;
        }
        return temp;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inorder[] = new int[n];
        int postorder[] = new int[n];
        for(int i = 0;i<inorder.length;i++){
            inorder[i] = sc.nextInt();
        }
        for(int i = 0;i<postorder.length;i++){
            postorder[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int query[][]= new int[q][2];
        for(int i = 0;i<query.length;i++){
            for(int j = 0;j<query[0].length;j++){
                query[i][j] = sc.nextInt();
            }
        }
        Node root = BuildTree(postorder,inorder);
        for(int i = 0;i<q;i++){
            System.out.println(query(query[i][0],query[i][1],root).toString());
        }
        sc.close();
    }
}
