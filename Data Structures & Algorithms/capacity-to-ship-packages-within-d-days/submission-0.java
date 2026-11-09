class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for(int weight:weights){
            left = Math.max(left, weight);
            right += weight;
        }

        while(left < right){
            int mid = left + (right - left)/2;

            int day = 1, load = 0;
            for(int weight:weights){
                if(load + weight > mid){
                    day++;
                    load = 0;
                }
                load += weight;
            }

            if(day <= days){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}