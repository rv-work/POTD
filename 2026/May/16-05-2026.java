class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                ans = Math.min(ans, nums[low]);
                low++;
                high--;
                continue; 
            }
            
            // already sorted
            if (nums[low] < nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            
            // Case 1: Left half sorted hai
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } 
            // Case 2: Right half sorted hai
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        
        return ans;
    }
}