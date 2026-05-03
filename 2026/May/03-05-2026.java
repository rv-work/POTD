

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        s = s + s;
        
        int n = s.length();
        int m = goal.length();
     
        for (int i = 0; i <= n - m; i++) {
            boolean isMatch = true;
            
            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) != goal.charAt(j)) {
                    isMatch = false;
                    break;          
                }
            }
            
            if (isMatch) {
                return true;
            }
        }
        
        return false;
    }
}

