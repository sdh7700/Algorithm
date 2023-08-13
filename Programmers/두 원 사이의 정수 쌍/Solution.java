class Solution {
  public long solution(int r1, int r2) {
    long answer = 0;
    return findDotCount(r2, true) - findDotCount(r1, false);
  }

  // 원안에 존재하는 점의 개수 찾기 함수
  public long findDotCount(int r, boolean isContainEdge) {
    long count = 0;
    int pivot = r;
    // edge를 포함할 경우
    if (isContainEdge) {
      for (int i = 1; i <= r; i++) {
        while (i * i + pivot * pivot > r * r) {
          pivot--;
        }
        count += pivot + 1;
      }
    } else { // edge 미포함할 경우
      for (int i = 1; i < r; i++) {
        while (i * i + pivot * pivot >= r * r) {
          pivot--;
        }
        count += pivot + 1;
      }
    }

    return count * 4 + 1;
  }
}