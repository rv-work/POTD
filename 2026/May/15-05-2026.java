

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = low;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
           
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            else {
                ans = mid;
                high = mid-1; 
            }
        }
        
        return nums[ans];
    }
}