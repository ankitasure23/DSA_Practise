/*23. Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: [] */

package Heaps;

import java.util.*;

public class MergeKSortedLists {

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode i : lists) {
            if (i != null)
                heap.add(i);
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null)
                heap.add(smallest.next);

        }
        return dummy.next;
    }
}

/*
 * Time Complexity:O(N * log K) ,Where N is the total number of nodes across all
 * K linked lists. Each insertion and extraction operation on the min-heap takes
 * O(log K) time, and we perform such operations N times (once per node). Hence,
 * the overall time complexity becomes O(N * log K).
 * 
 * Space Complexity:O(K),The heap stores at most K nodes at any time one from
 * each of the K linked lists. Therefore, the auxiliary space used by the
 * priority queue is O(K). The final merged linked list uses O(1) extra space if
 * we disregard the output list, as the nodes are rearranged rather than copied.
 */