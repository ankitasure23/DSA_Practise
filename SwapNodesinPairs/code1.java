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
    public ListNode swapPairs(ListNode head) {
        ListNode prevNode = null;
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode kthNode = null , newHead = null;
        if(head == null || head.next == null) return head;
        while(temp != null) {
            kthNode = temp.next;
            if(kthNode != null) 
                nextNode = kthNode.next;
            else{
                prevNode.next = temp; break;
            }
            kthNode.next = temp;
            temp.next = null;
            if(prevNode != null) 
                prevNode.next = kthNode;
            prevNode = temp;
            if(temp == head)
                newHead = kthNode;
            temp = nextNode;
        }
        return newHead;
    }
}
