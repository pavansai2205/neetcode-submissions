class Solution {
    private void sort(int[] arr, int low, int high){
        if(low < high){
            int part = partition(arr, low, high);
            sort(arr, low, part-1);
            sort(arr, part+1, high);
        }
    }
    private int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low, j = high;

        while(i < j){
            while(arr[i] <= pivot && i <= high - 1) i++;
            while(arr[j] > pivot && j >= low + 1) j--;
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int t = arr[low];
        arr[low] = arr[j];
        arr[j] = t;
        return j;
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        sort(nums, 0, n-1);
        return nums;
    }
}