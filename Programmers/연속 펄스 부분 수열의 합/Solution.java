class Solution {
  public long solution(int[] sequence) {
    long sum = 0;
    int maxIdx = 0;
    long maxValue = -1000000000;
    int purse = 1;

    long result = 0;
    // +-+-...
    for (int i = 0; i < sequence.length; i++) {
      sum += sequence[i] * purse;
      purse = purse * (-1);

      if (sum >= maxValue) {
        maxIdx = i;
        maxValue = sum;
      }
    }
    purse = 1;
    sum = maxValue;
    for (int i = 0; i <= maxIdx; i++) {
      sum -= sequence[i] * purse;
      purse = purse * (-1);
      if (sum >= maxValue) {
        maxValue = sum;
      }
    }
    result = maxValue;

    // -+-+...
    sum = 0;
    maxIdx = 0;
    maxValue = -1000000000;
    purse = -1;
    for (int i = 0; i < sequence.length; i++) {
      sum += sequence[i] * purse;
      purse = purse * (-1);

      if (sum >= maxValue) {
        maxIdx = i;
        maxValue = sum;
      }
    }
    purse = -1;
    sum = maxValue;
    for (int i = 0; i <= maxIdx; i++) {
      sum -= sequence[i] * purse;
      purse = purse * (-1);
      if (sum >= maxValue) {
        maxValue = sum;
      }
    }

    if (result < maxValue) {
      result = maxValue;
    }

    return result;
  }
}