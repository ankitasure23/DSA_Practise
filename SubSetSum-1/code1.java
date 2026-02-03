//using recursion
import java.util.*;

public class SubSetSum {
    public static void findSubsets(List<Integer> list, int[] nums, int sum, int i) {
        if (i >= nums.length) {
            list.add(sum);
            return;
        }
        findSubsets(list, nums, sum + nums[i], i + 1);
        findSubsets(list, nums, sum, i + 1);
    }

    public static void main(String[] args) {
        List<Integer> sum = new ArrayList<>();
        int[] nums = { 3, 1, 2 };
        findSubsets(sum, nums, 0, 0);
        Collections.sort(sum);
        System.out.println(sum);
    }
}
