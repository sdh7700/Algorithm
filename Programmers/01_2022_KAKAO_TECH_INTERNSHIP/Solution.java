class Solution {
  public int solution(int[] queue1, int[] queue2) {
    int answer = 0;
    int len = queue1.length;
    long sum1 = 0, sum2 = 0;
    int p1 = 0, p2 = 0;
    // 큐1 원소 합
    for (int i = 0; i < len; i++) {
      sum1 += queue1[i];
    }
    // 큐2 원소 합
    for (int j = 0; j < len; j++) {
      sum2 += queue2[j];
    }
    // 큐1+큐1 원소 합이 홀수일 경우 답x
    if ((sum1 + sum2) % 2 != 0) {
      return -1;
    }
    while (answer < len * 4) {
      // 합이 같아지면 리턴
      if (sum1 == sum2) {
        return answer;
      }
      // 큐1 원소 합 < 큐2 원소 합 일때
      else if (sum1 < sum2) {
        // 큐2의 피벗이 어느 위치인지 확인해서 큐1에 원소 넣기/큐2에서 원소 빼기
        if ((p2 / len) % 2 == 0) {
          sum1 += queue2[p2 % len];
          sum2 -= queue2[p2 % len];
        } else {
          sum1 += queue1[p2 % len];
          sum2 -= queue1[p2 % len];
        }
        p2++;
      } else {
        // 큐1의 피벗이 어느 위치인지 확인해서 큐2에 원소 넣기/큐1에서 원소 빼기
        if ((p1 / len) % 2 == 0) {
          sum2 += queue1[p1 % len];
          sum1 -= queue1[p1 % len];
        } else {
          sum2 += queue2[p1 % len];
          sum1 -= queue2[p1 % len];
        }
        p1++;
      }
      answer++;

    }
    return -1;
  }
}