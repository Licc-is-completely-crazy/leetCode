import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String args[]){
        Solution solution=new Solution();
        System.out.println(solution.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));

    }

    public int removeElement(int[] nums, int val) {
        int length=nums.length;
       for (;length>0;length--){
           if (nums[length-1]!=val){
               break;
           }
       }
       if (length<=0){
           return 0;
       }

       for (int i=0;i<length;i++){
           if (nums[i]==val){
               int left=length-remove(nums,val,i,length);
               for (int num :nums){
                   System.out.println(num);
               }
               return left;
           }
       }
       return length;

    }

    private int remove(int[] nums, int val, int removeIndex, int length) {
        int j = 1;
        for (int i = removeIndex + 1; i < length; i++) {
            if (nums[i] == val) {
                j = j + remove(nums, val, i, length);
            }
            nums[i - 1] = nums[i];
        }
        return j;
    }
}
