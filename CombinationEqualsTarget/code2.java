//prints only one subsequence.
class Solution {
    public static boolean combination(int[] arr, int target, int sum, List<List<Integer>> list, List<Integer> l, int i) {
        if(sum == target) {
            list.add(new ArrayList<>(l));
            return true;
        }
        if(sum > target || i >= arr.length) 
            return false;
        l.add(arr[i]);
        if(combination(arr,target,sum+arr[i],list,l,i) == true)
            return true;
        l.remove(l.size()-1);
        if(combination(arr,target,sum,list,l,i+1) == true)
            return true;
        return false;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combination(candidates,target,0,list,new ArrayList<>(),0);
        return list;
    }
}
