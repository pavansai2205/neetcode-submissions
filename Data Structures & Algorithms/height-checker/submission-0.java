class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];

        for(int i=0;i<heights.length;i++){
            expected[i] = heights[i];
        }
        Arrays.sort(expected);
        int i = 0, j = 0, count = 0;

        while(i < heights.length){
            if(heights[i] != expected[j]){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }
}