import java.util.*;

class Solution {
  public int solution(int n, int[][] results) {
    int answer = 0;
    int[][] check = new int[n + 1][n + 1];
    int[] count = new int[n + 1];
    for (int i = 0; i < results.length; i++) {
      check[results[i][0]][results[i][1]] = 1;
    }

    for (int k = 1; k < n + 1; k++) {
      for (int i = 1; i < n + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
          if (check[i][j] == 0 && check[i][k] == 1 && check[k][j] == 1) {
            check[i][j] = 1;
          }
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (check[i][j] == 1) {
          count[i]++;
          count[j]++;
        }
      }
    }

    for (int i = 1; i < n + 1; i++) {
      if (count[i] == n - 1) {
        answer++;
      }
    }

    return answer;
  }
}