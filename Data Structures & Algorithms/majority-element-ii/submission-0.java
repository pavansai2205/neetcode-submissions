class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int treshold = nums.length/3;

        for(int key:map.keySet()){
            if(map.get(key) > treshold){
                res.add(key);
            }
        }
        return res;
    }
}