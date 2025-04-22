import java.util.*;
public class Program1{
    static class Node{
        Node links[];
        boolean flag;

        Node(){
            links = new Node[26];
            flag = false;
        }

        public void put(char ch,Node node){
            links[ch-'a'] = node;
        }

        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }

        public Node get(char ch){
            return links[ch-'a'];
        }

        public void setflag(){
            flag = true;
        }

        public boolean isEnd(){
            return flag;
        }
    }

    static class Trie{
        Node root;
        Trie(){
            root = new Node();
        }

        public void insert(String str){
            Node node = root;
            for(int i = 0;i<str.length();i++){
                char ch = str.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch,new Node());
                }
                node = node.get(ch);
            }
            node.setflag();
        }

        public List<int[]> search(String str){
            List<int[]> res = new ArrayList<>();
            for(int i = 0;i<str.length();i++){
                Node node = root;
                for(int j = i;j<str.length();j++){
                    char ch = str.charAt(j);
                    if(!node.containsKey(ch)){
                        break;
                    }
                    node = node.get(ch);
                    if(node.isEnd()){
                        res.add(new int[]{i,j});
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String mainString = "phishphishingphish";
        String[] words = {"phish", "phishing"};

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<int[]> positions = trie.search(mainString);
        Collections.sort(positions,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for (int[] pos : positions) {
            System.out.println(pos[0] + " " + pos[1]);
        }
    }
}