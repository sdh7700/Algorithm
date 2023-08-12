class Solution {
  public int findPeakElement(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    // 길이가 1일 경우
    if (nums.length == 1) {
      return 0;
    }
    // 길이가 2 이상일 경우 이분탐색
    while (l <= r) {
      int m = (l + r) / 2;

      // m이 양 끝에 있을 경우
      if (m == 0 || m == nums.length - 1) {
        if (m == 0 && nums[m] > nums[m + 1] || m == nums.length - 1 && nums[m] > nums[m - 1]) {
          return m;
        } else if (m == 0 && nums[m] < nums[m + 1]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      } else { // m이 중간에 있을 경우
        if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
          return m;
        } else if (nums[m] > nums[m - 1] && nums[m] < nums[m + 1]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }
    }
    return 0;
  }
}