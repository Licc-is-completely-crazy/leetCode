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
//        return choose(length-1,nums);
        return dynamic(length-1,nums);
    }
    //TODO 这种递归冗余了很多计算，当数组长度在50时就执行的很慢了
    //TODO 我们对递归的顺序等因素进行规划的过程 才叫做动态规划
    private int choose(int k,int[] nums){
        if (k==0){
            return nums[0];
        }
        if (k==1){
            return Math.max(nums[0],nums[1]);
        }
        return  Math.max(choose(k-2,nums)+nums[k],choose(k-1,nums));
    }

    //TODO
//    动态规划的要素：
//    1.重叠子问题：减少子问题的重复计算是使用动态规划的"基本动机"，
//    合理规划子问题的执行顺序 增加一定的空间开销
//    2.蛮力找最优：动态规划策略所基于的递归旺旺基于蛮力遍历所有可能的特征
//    3.最优子结构：递归求解的基本形式是"小问题"的解组合得到"大问题"的解。
//    必须原始问题及其所有子问题都需求最优解，我们的递归求解才能正常进行，后续的动态
//    规划才能成为可能


    //参考优化斐波那契数列的优化方式进行优化
    private int dynamic(int k,int[] nums){
        int most[]=new int[nums.length];
        if (k==0){
            return nums[0];
        }
        if (k==1){
            return Math.max(nums[0],nums[1]);
        }
        most[0]=nums[0];
        most[1]=nums[1];
        for (int i=2;i<=k;i++){
            most [i]=Math.max(most[i-2]+nums[i],most[i-1]);
        }
        return most[k];
    }




}
