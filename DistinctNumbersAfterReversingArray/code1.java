class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
            int num = nums[i];
            int ans = 0;
            while(num != 0) {
                int rev = num%10;
                ans = ans*10 + rev;
                num /= 10;
            }
            set.add(ans);
        }
        return set.size();
    }
}


Approach

Traverse the array nums one by one.

For each number:

Add the number itself to a set (to keep only distinct elements).

Reverse the digits of the number and add the reversed number to the set.

Return the size of the set, which represents the total count of distinct integers (original + reversed). [A set in java stores only distinct items] .
    Time complexity : O(n*d) where n = number of elements in the array and d = number of digits in the array. Practically, since integers are ≤ 10^9, d ≤ 10, so the algorithm runs effectively in O(n) time.
    Space complexity : O(n)
    
    
    If the constraints of the input array is given we can use a boolean array to mark the number that appear either as the array element or the reversed version of the array element . That would reduce the space complexity .
    class Solution {
    public int countDistinctIntegers(int[] nums) {
        int count = 0;
        boolean[] seen = new boolean[1000001];
        for (int x : nums) {
            if (!seen[x]) count++;
            seen[x] = true;
            int y = 0;
            while (x > 0) {
                y = y * 10 + (x % 10);
                x /= 10;
            }
            if (!seen[y]) count++;
            seen[y] = true;
        }
        return count;
    }
}
