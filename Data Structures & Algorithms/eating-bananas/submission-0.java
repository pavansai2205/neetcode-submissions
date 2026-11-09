class Solution {
    private int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int pile:piles){
            max = Math.max(max, pile);
        }
        return max;
    }
    private int calcHour(int[] piles, int mid){
        int hour = 0;
        for(int pile:piles){
            hour += Math.ceil((double) pile/mid);
        }
        return hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = findMax(piles);
        while(left <= right){
            int mid = left + (right - left)/2;
            int hours = calcHour(piles, mid);
            if(hours <= h){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
