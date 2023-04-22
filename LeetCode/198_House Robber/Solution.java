class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int max=0;
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            max = nums[0]>nums[1] ? nums[0] : nums[1];
            return max;
        }
        result[0] = nums[0];
        result[1] = nums[1];
        result[2] = nums[0] + nums[2];
        
        max = result[1] > result[2] ? result[1] : result[2];
        
        for(int i=3; i<len; i++){
           result[i] = result[i-2] > result[i-3] ? result[i-2] + nums[i] : result[i-3] + nums[i];
            
            if(max<result[i]){
                max = result[i];
            }
       }
        
        return max;
    }
}