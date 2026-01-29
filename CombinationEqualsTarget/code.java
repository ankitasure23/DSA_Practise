class Solution {
    public static void combination(int[] arr, int target, int sum, List<List<Integer>> list, List<Integer> l, int i) {
        if(sum == target) {
            list.add(new ArrayList<>(l));
            return;
        }
        if(sum > target || i >= arr.length) 
            return;
        l.add(arr[i]);
        combination(arr,target,sum+arr[i],list,l,i);
        l.remove(l.size()-1);
        combination(arr,target,sum,list,l,i+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combination(candidates,target,0,list,new ArrayList<>(),0);
        return list;
    }
}
