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


In this approach we traverse through the array one by one , store the number in the set , reverse the number and then store the reversed number in the set . [A set in java stores only distinct items] .
