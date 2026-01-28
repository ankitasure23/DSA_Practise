class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for(int num = 0;num < 1 << n;num++) {
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<n;i++) {
                if((num & (1 << i)) != 0) 
                    l.add(nums[i]);
            }
            list.add(l);
        }
        return list;
    }
}
