import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int target = -1;
        Arrays.sort(targets, Comparator.comparingInt((int[] o) -> o[1]));
        for(int i=0; i<targets.length; i++){
            if(targets[i][0] >= target){
                target = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}