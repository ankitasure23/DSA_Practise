/*621. Task Scheduler
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 */
/*We want to execute all given tasks such that the same task type appears at least n time units apart. One brute force way to do this is by simulating the process. We use a max heap to always pick the task with the highest remaining frequency. In each unit of time, we execute a task if possible otherwise, we insert idle time. This approach ensures we respect the cooldown constraint but may add unnecessary idle time due to its greedy nature.
Count the frequency of each task using a hash map.
Push all frequencies into a max-heap (priority queue).
While the heap is not empty:
Initialize an empty temporary list to hold tasks in current cycle.
For a total of (n + 1) units of time, try to execute the most frequent remaining task:
Pop the task with highest frequency from heap.
Decrement its frequency and store it in temporary list if it still has counts left.
Increment total time for each executed or idle unit.
Push all tasks from the temporary list back into the heap.
Return total time taken including idles. */
package Heaps;

import java.util.*;

public class TaskScheduler {

}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int time = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : map.values()) {
            heap.add(i);
        }
        while (!heap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            int i = 0;
            while (i < cycle && !heap.isEmpty()) {
                int count = heap.poll();
                count--;
                if (count > 0)
                    temp.add(count);
                time++;
                i++;
            }
            for (int v : temp) {
                heap.add(v);
            }
            if (!heap.isEmpty())
                time += (cycle - i);
        }
        return time;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int time = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : map.values()) {
            heap.add(i);
        }
        while (!heap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            int i = 0;
            while (i < cycle && !heap.isEmpty()) {
                int count = heap.poll();
                count--;
                if (count > 0)
                    temp.add(count);
                time++;
                i++;
            }
            for (int v : temp) {
                heap.add(v);
            }
            if (!heap.isEmpty())
                time += (cycle - i);
        }
        return time;
    }
}

/*
 * Time Complexity:O(N log K), We count frequencies in O(N) and use a max heap
 * of K unique tasks. Each task can be pushed and popped from the heap multiple
 * times resulting (log K) per operation.
 * 
 * Space Complexity:O(K), We store task frequencies in a hashmap and use a max
 * heap, both taking O(K) space where K is the number of unique tasks.
 */