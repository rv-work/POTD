









class Solution {
    boolean dfs(int[] arr, int curr, boolean[] visited) {
        if (curr < 0 || curr >= arr.length) return false;
        
        if (visited[curr]) return false;
        
        if (arr[curr] == 0) return true;
        
        visited[curr] = true;
        
        return dfs(arr, curr + arr[curr], visited) || 
               dfs(arr, curr - arr[curr], visited);
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
}










class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (arr[curr] == 0) return true;
            
            int leftJump = curr - arr[curr];
            int rightJump = curr + arr[curr];
            
            if (rightJump < n && !visited[rightJump]) {
                visited[rightJump] = true;
                queue.add(rightJump);
            }
            
            if (leftJump >= 0 && !visited[leftJump]) {
                visited[leftJump] = true;
                queue.add(leftJump);
            }
        }
        
        return false; 
    }
}











class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }
        
        if (arr[start] == 0) {
            return true;
        }
        
        arr[start] = -arr[start];
        
     
        boolean canReachLeft = canReach(arr, start - Math.abs(arr[start]));
        boolean canReachRight = canReach(arr, start + Math.abs(arr[start]));
        
        return canReachLeft || canReachRight;
    }
}