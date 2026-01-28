class Solution {
    public static void generate(List<List<Integer>> list, int[] nums, List<Integer> l , int i) {
        if(i == nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        generate(list,nums,l,i+1);
        l.remove(l.size()-1);
        generate(list,nums,l,i+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        generate(list,nums,new ArrayList<>(),0);
        return list;
    }
}
