import java.util.*;
public class PrePost {
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

    public static Node buildTree(int preorder[],int postorder[]){
        if( preorder==null || postorder==null || preorder.length!=postorder.length){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return helper(preorder,postorder,0,preorder.length-1,0,postorder.length-1,map);
    }

    public static Node helper(int preorder[],int postorder[],int pres,int pree,int posts,int poste,Map<Integer,Integer> map){
        if(pres>pree || posts>poste){
            return null;
        }
        Node root = new Node(preorder[pres]);
        if(pres+1<=pree){
            int idx = map.get(preorder[pres+1]);
            int leftSubtreeSize = idx - posts + 1;
            root.left = helper(preorder, postorder, pres + 1, pres + leftSubtreeSize, posts, idx, map);
            root.right = helper(preorder, postorder, pres + leftSubtreeSize + 1, pree, idx + 1, poste - 1, map);

        }
        return root;
    }

    public static List<List<Integer>> levelorder(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node sk = q.remove();
                temp.add(sk.data);
                if(sk.left!=null){
                    q.add(sk.left);
                }
                if(sk.right != null){
                    q.add(sk.right);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String[] prestr = sc.nextLine().split(" ");
        String[] poststr = sc.nextLine().split(" ");
        int preorder[] = new int[prestr.length];
        int postorder[] = new int[poststr.length];
        for(int i = 0;i<prestr.length;i++){
            preorder[i] = Integer.parseInt(prestr[i]);
            postorder[i] = Integer.parseInt(poststr[i]);
        }
        Node root = buildTree(preorder, postorder);
        System.out.println(levelorder(root));
        sc.close();
    }
}
