public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();


    }

    public int search(int[] nums, int target){
        return realsearch(nums,target,0,nums.length-1);
    }

    public int realsearch(int[] nums, int target,int low,int high) {
        for (;low<high;) {
            int mid=(low+high)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[low]<=target&&target<=nums[mid]){
                high=mid-1;
                continue;
            }else if (nums[mid]<=target&&target<=nums[high]){
                low=mid+1;
                continue;
            }else {
               return realsearch(nums,target,mid+1,high);
            }
        }
        return -1;
    }

//    private int findRotatedIndex(int[] nums){
//
//
//
//    }
}
