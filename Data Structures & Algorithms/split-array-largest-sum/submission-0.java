class Solution {
    private boolean canSplit(int[] nums, int k, int maxSum){
        int subarray = 1, currSum = 0;
        for(int num:nums){
            currSum += num;
            if(currSum > maxSum){
                subarray++;
                if(subarray > k) return false;
                currSum = num;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for(int num:nums){
            left = Math.max(left, num);
            right += num;
        }
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(canSplit(nums, k, mid)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}