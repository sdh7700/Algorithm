import java.util.*;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    // 첫번째 변수 넣기
    list.add(nums[0]);
    result.add(list);

    // 두번째 변수부터 차례대로 순회
    for (int i = 1; i < nums.length; i++) {
      // 몇 번째 변수인지, 그 개수만큼 꺼내기
      while (result.get(0).size() == i) {
        List<Integer> temp = result.remove(0);
        // 해당 list의 모든 index에 추가하기
        for (int j = 0; j <= temp.size(); j++) {
          List<Integer> newList = new LinkedList<>(temp);
          newList.add(j, nums[i]);
          result.add(newList);
        }
      }
    }

    return result;
  }
}