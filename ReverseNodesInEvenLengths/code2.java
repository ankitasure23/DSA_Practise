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
    public static void reverse(ListNode node) {
        if(node == null || node.next == null) return;
        ListNode prev = null;
        ListNode nextNode = node.next;
        while(node != null){
            node.next = prev;
            prev = node;
            node = nextNode;
            if(nextNode != null)
                nextNode = nextNode.next;
        }
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prevNode = null;
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

            if(count < group) {
                if(count % 2 == 0) {
                    reverse(temp);
                    prevNode.next = kthNode;
                    break;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
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
