class Solution {
    public int specialArray(int[] nums) {
        int left = 1, right = nums.length;

        while(left <= right){
            int mid = (left + right)/2;
            int cnt = 0;
            for(int num:nums){
                if(num >= mid) cnt++;
            }
            if(cnt == mid) return mid;
            if(cnt < mid) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}