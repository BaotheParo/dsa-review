class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();
        backtrack(0,nums, target, 0, currCombination, result);
        return result;
    }
    private void backtrack(int i , int[] nums, int target, int total, List<Integer> currCombination, List<List<Integer>> result){
        if (total == target){
            result.add(new ArrayList<>(currCombination));
            return;
        }
        if(total>target || i>=nums.length){
            return;
        }
        currCombination.add(nums[i]);
        backtrack(i, nums, target, total + nums[i], currCombination, result);
        currCombination.remove(currCombination.size()-1);
        backtrack(i+1,nums,target,total,currCombination,result);
    }
}
