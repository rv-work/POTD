
// class Solution {
//     public boolean isGood(int[] nums) {
//         int n = nums.length - 1; 
        
//         Arrays.sort(nums);
        
//         for (int i = 0; i < n; i++) {
//             if (nums[i] != i + 1) {
//                 return false;
//             }
//         }
        
//         return nums[n] == n;
//     }
// }



// class Solution {
//     public boolean isGood(int[] nums) {
//         int n = nums.length - 1;
        
//         if (nums.length < 2) return false;
        
//         int[] freq = new int[n + 2]; 
        
//         for (int num : nums) {
//             if (num < 1 || num > n) {
//                 return false;
//             }
//             freq[num]++;
//         }
        
//         for (int i = 1; i < n; i++) {
//             if (freq[i] != 1) {
//                 return false;
//             }
//         }
        
//         return freq[n] == 2;
//     }
// }







class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int num : nums) {
            if (num < 1 || num > n) return false;
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 1; i < n; i++) {
            if (counts.getOrDefault(i, 0) != 1) return false;
        }
        
        return counts.getOrDefault(n, 0) == 2;
    }
}