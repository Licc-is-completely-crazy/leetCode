import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int nums[]=new int[]{-1, 0, 1, 2, -1, -4};
//        Arrays.sort(nums);

        solution.fastsort(nums,0,nums.length-1);
       for (int a:nums){
           System.out.println(a);
       }
        System.out.println(solution.threeSum(nums));
    }


    public List<List<Integer>> threeSum(int[] nums) {

        if (nums==null||nums.length==0){
            return Collections.emptyList();
        }
        fastsort(nums,0,nums.length-1);
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        for (int k=0;k<nums.length-1;k++){
            if (k>0&&nums[k]==nums[k-1]){
                continue;
            }

            int i=k+1;
            int j=nums.length-1;
            for (;i<j;){
                if (i>k+1&&nums[i]==nums[i-1]){
                    i++;
                    continue;
                }
                int target=nums[k];
                int first=nums[i];
                int second=nums[j];

                if (first+second+ target>0){
                    j--;
                }else if (first+second+ target<0){
                    i++;
                }else {
                    List list = new ArrayList<Integer>();
                    list.add(target);
                    list.add(first);
                    list.add(second);
                    result.add(list);
                    i++;
                }


            }
        }
        return result;
    }

    public void fastsort(int[] array,int begin,int end){
        if (begin<end){
            int index=sort(array,begin,end);
            fastsort(array,begin,index-1);
            fastsort(array,index+1,end);
        }
    }

    public int sort(int[] array,int begin,int end){
        int stand=array[begin];
//        System.out.println("========stand:"+stand+" begin:"+begin+" end:"+end);
        int i=begin;
        int j=end;
        for (;i<j;){
            for (;i<j;j--){
                if (array[j]<stand){
                    array[i]=array[j];
                    break;
                }
            }
            for (;i<j;i++){
                if (array[i]>stand){
                   array[j]=array[i];
                   break;
                }
            }
        }
        array[i]=stand;


//        for (int k:array){
//            System.out.println(k);
//        }
        return i;
    }
}
