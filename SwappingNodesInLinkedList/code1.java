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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        temp = head;
        for(int i=2;i<=k;i++) {
            temp = temp.next;
        }
        ListNode node = head; 
        for(int i=1;i<=size-k;i++) {
            node = node.next;
        }
       int curr = temp.val;
       temp.val = node.val;
       node.val = curr;
       return head; 
    }
}
