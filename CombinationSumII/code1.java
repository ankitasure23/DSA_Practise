class Solution {
    public static void combination (List<List<Integer>> list, List<Integer> l, int[] arr,int target, int i) {
        if(target == 0) {
            list.add(new ArrayList<>(l));
            return;
        }
        if(i >= arr.length || target < 0 || arr[i] > target) {
            return;
        }
        l.add(arr[i]);
        combination(list,l,arr,target - arr[i],i+1);
        while(i < arr.length-1 && arr[i] == arr[i+1]) {
            i++;
        }
        l.remove(l.size()-1);
        combination(list,l,arr,target,i+1);
      }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        combination(list,l,candidates,target,0);
        return list;
    }
}
