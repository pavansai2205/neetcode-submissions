class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num:nums){
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        ArrayList<Integer> values = new ArrayList<>();

        for(int value:map.keySet()){
            values.add(value);
        }
        values.sort((first, second) -> map.get(second) - map.get(first));

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = values.get(i);
        }
        return ans;
    }
}
