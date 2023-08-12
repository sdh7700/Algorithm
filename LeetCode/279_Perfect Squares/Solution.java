class Solution {
  public int numSquares(int n) {
    int answer = 0;

    int[] nums = new int[10001];
    for (int i = 1; i < 100; i++) {
      nums[i * i] = 1;
      nums[i * i + 1] = 2;
    }
    nums[0] = 0;

    for (int i = 1; i <= n; i++) {
      if (nums[i] == 0) {
        int min = 10000;
        // k는 i보다 작은 완전제곱근(i가 15일 때 k^2은 9 -> k는 3)
        int k = 1;
        while (k * k < i) {
          int num = 1 + nums[i - k * k];
          if (num < min) {
            min = num;
          }
          k++;
        }
        nums[i] = min;
      }
    }

    return nums[n];
  }
}