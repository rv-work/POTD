
class Solution {

    int getMaxVal(int[] nums) {
        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }
        return maxVal;
    }
    
    int[] buildSPF(int maxVal) {
        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            spf[i] = i;
        }
        
        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    boolean[] getPresentPrimes(int[] nums, int[] spf, int maxVal) {
        boolean[] isPresentPrime = new boolean[maxVal + 1];
        for (int x : nums) {
            if (x > 1 && spf[x] == x) {
                isPresentPrime[x] = true;
            }
        }
        return isPresentPrime;
    }

    List<Integer>[] buildTeleportGraph(int[] nums, int[] spf, boolean[] isPresentPrime, int maxVal) {
        List<Integer>[] primeToIndices = new ArrayList[maxVal + 1];
        
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int lastPrime = 0;
            
            while (temp > 1) {
                int p = spf[temp];
                if (p != lastPrime) {
                    if (isPresentPrime[p]) {
                        if (primeToIndices[p] == null) {
                            primeToIndices[p] = new ArrayList<>();
                        }
                        primeToIndices[p].add(i);
                    }
                    lastPrime = p;
                }
                temp /= p;
            }
        }
        return primeToIndices;
    }

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        int maxVal = getMaxVal(nums);
        int[] spf = buildSPF(maxVal);
        boolean[] isPresentPrime = getPresentPrimes(nums, spf, maxVal);
        List<Integer>[] primeToIndices = buildTeleportGraph(nums, spf, isPresentPrime, maxVal);
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedIdx = new boolean[n];
        boolean[] visitedPrime = new boolean[maxVal + 1];
        
        q.offer(0);
        visitedIdx[0] = true;
        int jumps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                
                if (curr == n - 1) return jumps;
                
                if (curr + 1 < n && !visitedIdx[curr + 1]) {
                    visitedIdx[curr + 1] = true;
                    q.offer(curr + 1);
                }
                if (curr - 1 >= 0 && !visitedIdx[curr - 1]) {
                    visitedIdx[curr - 1] = true;
                    q.offer(curr - 1);
                }
                
                int val = nums[curr];
                if (val > 1 && spf[val] == val) {
                    if (!visitedPrime[val]) {
                        visitedPrime[val] = true;
                        
                        if (primeToIndices[val] != null) {
                            for (int nextIdx : primeToIndices[val]) {
                                if (!visitedIdx[nextIdx]) {
                                    visitedIdx[nextIdx] = true;
                                    q.offer(nextIdx);
                                }
                            }
                        }
                    }
                }
            }
            jumps++;
        }
        
        return -1;
    }
}