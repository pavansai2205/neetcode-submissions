class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int num:nums1){
            s1.add(num);
        }
        
        for(int num:nums2){
            s2.add(num);
        }

        int n = s1.size() > s2.size() ? s1.size() : s2.size();
        int[] res = new int[n];
        int idx = 0;
        for(int num:s1){
            if(s2.contains(num)){
                res[idx++] = num;
            }
        }
        return Arrays.copyOfRange(res, 0, idx);
    }
}