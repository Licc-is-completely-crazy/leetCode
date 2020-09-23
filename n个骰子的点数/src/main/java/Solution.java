import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s=new Solution();
        double[] result=s.twoSum(1);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);

        }

    }



    public double[] twoSum(int n) {
        //回溯结果，计算和，map.put
        int[] result=new int[n];
        HashMap<Integer,Integer> map=new HashMap();
        throwTh(0,result,map,n-1);
        Set<Integer> sumSet=map.keySet();
        int valueSum=0;
        for(Integer sum: map.values()){
            valueSum=valueSum+sum;
        }
        Object[] sumArray=sumSet.toArray();
        Arrays.sort(sumArray);
        double[] finallyResult=new double[map.keySet().size()];
        for(int j=0;j<map.keySet().size();j++){
            finallyResult[j]=map.get(sumArray[j]).doubleValue()/valueSum;
        }
        return finallyResult;
    }
    private void throwTh(int now,int[] result,Map<Integer,Integer> map,int target){
        if(now>target){
            int sum=0;
            for(int i=0;i<result.length;i++){
                sum=sum+result[i];
            }
            Integer times=map.get(sum);
            if(times==null){
                times=1;
            }else{
                times++;
            }

            map.put(sum,times);
            return;
        }
        for(int i=1;i<=6;i++){
            result[now]=i;
            throwTh(now+1,result,map,target);
        }

    }
}