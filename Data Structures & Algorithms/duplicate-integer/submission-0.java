class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        for(int i=0;i<nums.length;i++ ){
            if(!duplicate.add(nums[i])) return true;
        }
        return false;
    }
}