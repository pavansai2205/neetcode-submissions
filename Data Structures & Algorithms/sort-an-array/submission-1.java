class Solution {
    private void merge(int[] arr, int left, int mid, int right){
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        } 
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= right){
            temp[k++] = arr[j++];
        }
        for(int l=0;l<temp.length;l++){
            arr[left + l] = temp[l];
        }
    }
    private void sort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        sort(nums, 0, n-1);
        return nums;
    }
}