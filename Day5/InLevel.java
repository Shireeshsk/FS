import java.util.*;
public class InLevel {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(int inorder[],int levelorder[]){
        if(inorder==null || levelorder==null || inorder.length!=levelorder.length){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(inorder,levelorder,0,inorder.length-1,0,levelorder.length-1,map);
    }

    public static Node helper(int inorder[],int levelorder[],int ins,int ine,int levels,Map<Integer,Integer> map){
        if(ins>ine){
            return null;
        }
        Node root = new Node(levelorder[levels]);
        int idx = map.get(root.data);
        List<Integer> temp = new ArrayList<>();
        for(int i = ins;i<=idx;i++){
            temp.add(inorder[i]);
        }
        List<Integer> leftlevel = new ArrayList<>();
        List<Integer> rightlevel = new ArrayList<>();
        for(int i = levels+1;i<levelorder.length;i++){
            if(temp.contains(levelorder[i])){
                rightlevel.add(levelorder[i]);
            }
            else{
                leftlevel.add(levelorder[i]);
            }
        }
        root.left = helper(inorder,,ins,idx-1,levels+1,map);
        root.right = helper(inorder,,idx+1,ine,levels)
    }
}
