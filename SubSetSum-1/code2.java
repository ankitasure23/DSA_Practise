//using bitmasking 
import java.util.*;

public class SubSetSum {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int n = nums.length;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += nums[j];
                }
            }
            sums.add(sum);
        }
        Collections.sort(sums);
        System.out.println(sums);
    }
}
