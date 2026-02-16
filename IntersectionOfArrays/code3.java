If provided that nums1 is always the smaller array . 
  Time complexity : O(n + m)
  Space complexity : O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2,nums1);
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int num:nums1) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                map.put(num,map.get(num)-1);
                result.add(num);
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
