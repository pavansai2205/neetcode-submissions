class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] seen = new int[k];
        seen[0] = 1;
        int prefix = 0, res = 0;
        for(int num:nums){
            prefix = (prefix + num % k + k) % k;
            res += seen[prefix]++;
        }
        return res;
    }
}