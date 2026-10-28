class Solution {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;

        while(i <= r) {
            if(nums[i] == 0){
                swap(nums, l, i);
                l++;
            } else if(nums[i] == 2){
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }
}