If the array is already sorted . 
  Time complexity : O(n+m)
  Space complexity : O(min(n,m))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0,j = 0;
        List<Integer> list = new ArrayList<>();
        int c = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            } 
        }
        int[] arr = new int[list.size()];
        for(int ind=0;ind<list.size();ind++) {
            arr[ind] = list.get(ind);
        }
        return arr;
    }
}
