import java.util.*;
public class reverseLL{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static Node buildLL(int arr[]){
        if(arr.length==0) return null;
        int idx = 0;
        Node head = new Node(arr[idx++]);
        Node curr = head;
        while(idx<arr.length){
            curr.next = new Node(arr[idx++]);
            curr = curr.next;
        }
        return head;
    }
    
    public static Node MidNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public static boolean isPalindrome(Node head){
        if(head == null){
            return true;
        }
        Node mid = MidNode(head);
        Node end = reverse(mid.next);
        while(end!=null){
            if(head.data != end.data){
                return false;
            }
            head = head.next;
            end = end.next;
        }
        return true;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int arr[] = new int[str.length];
        for(int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Node head = buildLL(arr);
        System.out.println(isPalindrome(head));
    }
}