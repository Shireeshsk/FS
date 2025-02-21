import java.util.*;
public class InPre_SpiralOrder {
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

    public static Node BuildTree(int inorder[],int preorder[]){
        if(preorder==null || inorder == null || inorder.length != preorder.length ){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,preorder,0,inorder.length-1,0,preorder.length-1,map);
    }

    public static Node helper(int inorder[],int preorder[],int ins,int ine,int pres,int pree,Map<Integer,Integer> map){
        if(ins>ine || pres>pree){
            return null;
        }
        Node root = new Node(preorder[pres]);
        int idx = map.get(root.data);
        root.left = helper(inorder,preorder,ins,idx-1,pres+1,pres+(idx-ins),map);
        root.right = helper(inorder,preorder,idx+1,ine,pres+(idx-ins)+1,pree,map);
        return root;
    }

    public static List<Integer> query(int n1,int n2,Node root){
        List<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node sk = q.remove();
                if(level>=n1 && level<=n2){
                    if(level%2!=0 ){
                        res.add(sk.data);
                    }
                    else{
                        temp.add(sk.data);
                    }
                }
                if(sk.left!=null){
                    q.add(sk.left);
                }
                if(sk.right!=null){
                    q.add(sk.right);
                }
            }
            if(level%2==0){
                for(int i = temp.size()-1;i>=0;i--){
                    res.add(temp.get(i));
                }
            }
            if(level == n2){
                break;
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inorder[] = new int[n];
        int preorder[] = new int[n];
        for(int i = 0;i<inorder.length;i++){
            inorder[i] = sc.nextInt();
        }
        for(int i = 0;i<preorder.length;i++){
            preorder[i] = sc.nextInt();
        }
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        Node root = BuildTree(inorder, preorder);
        System.out.println(query(n1, n2,root));
        sc.close();
    }
}
