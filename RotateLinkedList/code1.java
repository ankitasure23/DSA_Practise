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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next != null) {
            tail = tail.next;
            len++;
        }
        if(k > len) {
            k = k % len;
        }
        else if(k % len == 0) k = 0;
        ListNode temp = head;
        for(int i=2;i<=(len-k);i++) {
            temp = temp.next;
        }
        tail.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}
