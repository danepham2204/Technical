package day2402026;

public class EasyArray {
  public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n * 2];
    for (int i = 0; i < n; i++) {
      arr[i] = nums[i];
      arr[i + n] = nums[i];
    }
    return arr;
  }

  public int[] getConcatenation2(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n * 2];
    System.arraycopy(nums, 0, arr, 0, n);
    System.arraycopy(nums, 0, arr, n, n);

    return arr;
  }

  public static void main(String[] args) {
    EasyArray solution = new EasyArray();
    int[] nums = { 1, 2, 3 };
    int[] arr = solution.getConcatenation(nums);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    int[] arr2 = solution.getConcatenation2(nums);
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.out.println();
  }
}
