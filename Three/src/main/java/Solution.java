public class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int nums[]={114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(solution.rob(nums));;
    }

    public  int rob(int[] nums) {
        int length=nums.length;
        if (length==0){
            return 0;
        }
        return choose(length-1,nums);
    }
    private int choose(int k,int[] nums){
        if (k==0){
            return nums[0];
        }
        if (k==1){
            return Math.max(nums[0],nums[1]);
        }
        return  Math.max(choose(k-2,nums)+nums[k],choose(k-1,nums));
    }




}
