
class Solution {
  public int maxRotateFunction(int[] nums) {
    int n = nums.length;
    int sum = 0;
    int f0 = 0;

    for (int i = 0; i < n; i++) {
      sum += nums[i];
      f0 += i * nums[i];
    }

    int maxVal = f0;
    int currF = f0;

    for (int k = 1; k < n; k++) {

      int newF = currF + sum - (n * nums[n - k]);
      maxVal = Math.max(maxVal, newF);
      currF = newF;

    }

    return maxVal;
  }
}