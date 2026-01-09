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
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode = head.next;
        ListNode temp = head;
        ListNode kthNode = temp;
        int group = 1;
        int count = 0;
        while(temp != null) {
            count = 1;
            kthNode = temp;
            for(int i=2;i<=group;i++) {
                if(kthNode.next!=null) {
                    count++;
                    kthNode = kthNode.next;
                }
                else {
                    break;
                }
            }
            System.out.println(count + " " + group);
            if(count < group && count % 2 != 0) {
                break;
            }
            if(count < group && count % 2 == 0) {
                reverse(temp);
                prevNode.next = kthNode;
                break;
            }
            nextNode = kthNode.next;
            if(group % 2 != 0) {
                temp = nextNode;
                group++;
                prevNode = kthNode;
            }
            else {
                kthNode.next = null;
                reverse(temp);
                temp.next = nextNode;
                prevNode.next = kthNode;
                prevNode = temp;
                temp = nextNode;
                group++;
            }
        }
        return head;
    }
}
