//using recursion
class Solution {
    public static void findSubsets(List<List<Integer>> list, List<Integer> l,int[] nums, int i) {
        if(i >= nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[i]);
        findSubsets(list,l,nums,i+1);
        while(i < nums.length-1 && nums[i] == nums[i+1])
            i++;
        l.remove(l.size()-1);
        findSubsets(list,l,nums,i+1);
    } 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(list,new ArrayList<>(),nums,0);
        return list;
    }
}
