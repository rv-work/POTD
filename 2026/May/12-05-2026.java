


class Solution {

     boolean isPossible(int[][] tasks, int initial) {
        for (int[] task : tasks) {
            if (initial < task[1]) {
                return false;
            }
            initial -= task[0]; 
        }
        return true; 
    }

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int low = 0;
        int high = (int) 1e9; 
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(tasks, mid)) {
                ans = mid;      
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        
        return ans;
    }
}