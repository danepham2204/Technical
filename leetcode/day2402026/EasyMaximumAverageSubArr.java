package day2402026;

public class EasyMaximumAverageSubArr {
  public double findMaxAverage(int[] nums, int k) {
    if (nums.length < k) {
      throw new IllegalArgumentException();
    }
    int maxSum = 0;
    for (int i = 0; i < k; i++) {
      maxSum += nums[i];
    }
    int currSum = maxSum;

    for (int i = k; i < nums.length; i++) {
      currSum += (nums[i] - nums[i - k]);
      maxSum = Math.max(maxSum, currSum);
    }

    return maxSum * 1.0 / k;
  }

  public static void main(String[] args) {
    EasyMaximumAverageSubArr sol = new EasyMaximumAverageSubArr();
    System.out.println(sol.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
  }
}
