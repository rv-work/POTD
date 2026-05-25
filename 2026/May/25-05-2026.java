
// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
//         if (s.charAt(n - 1) == '1') return false;
        
//         Queue<Integer> q = new LinkedList<>();
//         boolean[] visited = new boolean[n]; 
        
//         q.offer(0);
//         visited[0] = true;
        
//         while (!q.isEmpty()) {
//             int curr = q.poll();
            
          
//             if (curr == n - 1) return true;
            
//             int start = curr + minJump;
//             int end = Math.min(curr + maxJump, n - 1); 
            
//             for (int i = start; i <= end; i++) {
//                 if (s.charAt(i) == '0' && !visited[i]) {
//                     visited[i] = true;
//                     q.offer(i);
//                 }
//             }
//         }
        
//         return false; 
//     }
// }















// class Solution {
//     boolean dfs(int curr, String s, int minJump, int maxJump, boolean[] visited) {
//         int n = s.length();
        
//         if (curr == n - 1) return true;
        
//         visited[curr] = true;
        
//         int start = curr + minJump;
//         int end = Math.min(curr + maxJump, n - 1);
        
//         for (int i = start; i <= end; i++) {
//             if (s.charAt(i) == '0' && !visited[i]) {
//                 if (dfs(i, s, minJump, maxJump, visited)) {
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }

//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
//         if (s.charAt(n - 1) == '1') return false;
        
//         boolean[] visited = new boolean[n];
        
//         return dfs(0, s, minJump, maxJump, visited);
//     }
    
    
// }


















// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
        
//         if (s.charAt(n - 1) == '1') return false;
        
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(0);
        
//         int farthest = 0;
        
//         while (!q.isEmpty()) {
//             int curr = q.poll();
            
//             if (curr == n - 1) return true;
            
//             int start = Math.max(curr + minJump, farthest + 1);
//             int end = Math.min(curr + maxJump, n - 1);
            
//             for (int i = start; i <= end; i++) {
//                 if (s.charAt(i) == '0') {
//                     q.offer(i);
//                 }
//             }
            
//             farthest = Math.max(farthest, end);
//         }
        
//         return false;
//     }
// }













// class Solution {
//     boolean dfs(int curr, String s, int minJump, int maxJump, boolean[] visited) {
//         int n = s.length();
        
//         if (curr == n - 1) return true;
        
//         visited[curr] = true;
        
//         int start = Math.max(curr + minJump, farthest + 1);
//         int end = Math.min(curr + maxJump, n - 1);
        
//         for (int i = start; i <= end; i++) {
//             if (s.charAt(i) == '0' && !visited[i]) {
//                 if (dfs(i, s, minJump, maxJump, visited)) {
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }

//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
//         if (s.charAt(n - 1) == '1') return false;
        
//         boolean[] visited = new boolean[n];
        
//         return dfs(0, s, minJump, maxJump, visited);
//     }
    
    
// }














// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
        
//         if (s.charAt(n - 1) == '1') return false;
        
//         boolean[] dp = new boolean[n];
//         dp[0] = true;
        
//         for (int i = 1; i < n; i++) {
//             if (s.charAt(i) == '0') {
//                 int start = Math.max(0, i - maxJump);
//                 int end = i - minJump;
                
//                 for (int j = start; j <= end; j++) {
//                     if (dp[j]) {
//                         dp[i] = true;
//                         break; 
//                     }
//                 }
//             }
//         }
        
//         return dp[n - 1];
//     }
// }















// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
        
//         if (s.charAt(n - 1) == '1') return false;
        
//         boolean[] dp = new boolean[n];
//         dp[0] = true;
//         int active = 0;
        
//         for (int i = 1; i < n; i++) {
//             if (i >= minJump && dp[i - minJump]) {
//                 active++;
//             }
            
//             if (i > maxJump && dp[i - maxJump - 1]) {
//                 active--;
//             }
            
//             if (active > 0 && s.charAt(i) == '0') {
//                 dp[i] = true;
//             }
//         }
        
//         return dp[n - 1];
//     }
// }















class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        
        if (s.charAt(n - 1) == '1') return false;
        
        int[] dp = new int[n];
        int[] pre = new int[n];
        
        dp[0] = 1;
        pre[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int l = Math.max(0, i - maxJump);
            int r = i - minJump;
            
            if (s.charAt(i) == '0' && r >= 0) {
                int sum = pre[r] - (l > 0 ? pre[l - 1] : 0);
                
                if (sum > 0) {
                    dp[i] = 1;
                }
            }
            
            pre[i] = pre[i - 1] + dp[i];
        }
        
        return dp[n - 1] == 1;
    }
}