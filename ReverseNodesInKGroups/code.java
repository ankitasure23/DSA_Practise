/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode prev = null;
        ListNode nextNode = node.next;
        while(node != null){
            node.next = prev;
            prev = node;
            node = nextNode;
            if(nextNode != null)
                nextNode = nextNode.next;
        }
        ListNode n = prev;
        /*while(n != null) {
            System.out.println(prev.val);
            n = n.next;
        }*/
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp =  head;
        ListNode prevNode = null;
        ListNode newHead = null; int count = 0;
        ListNode nextNode = head;
        while(temp != null) {
            ListNode kthNode = temp;
            for(int i=2;i<=k;i++) {
                if(kthNode.next != null) 
                    kthNode = kthNode.next;
                else {
                    count = 1;
                    temp = nextNode;
                    prevNode.next = temp;
                    break;
                }
            }
            if (count == 1) break;
            if(prevNode != null)
                prevNode.next = kthNode;
            nextNode = kthNode.next;
            kthNode.next = null;
            ListNode node = reverse(temp);
            prevNode = temp;
            if(temp == head)
                newHead = node;
            temp = nextNode;
        }
        return newHead;
    }

  
}
