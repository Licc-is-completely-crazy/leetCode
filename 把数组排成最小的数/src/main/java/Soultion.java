import java.util.ArrayList;
import java.util.List;

class Solution {
    public String minNumber(int[] nums) {
        //基数排序魔改
        // int[][] base=new int[10][];
        List<String>[] natureSort=new List[10];
        //初始化
        for(int i=0;i<natureSort.length;i++){
            natureSort[i]=new ArrayList();
        }

        //把整型数组转字符串数组
        String[] sNums=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            sNums[i]=String.valueOf(nums[i]);
        }
        //找长度最长的字符串
        int maxLength=0;
        for(String s:sNums){
            if(s.length()>maxLength){
                maxLength=s.length();
            }
        }


        //遍历最长字符串长度次
        for(int j=maxLength-1;j>=0;j--){
            //按第i位放桶。
            for(int i=0;i<sNums.length;i++){
                int chooseWhich=0;
                //超出当前字符串长度最大值用最后一位放桶
                if(j>sNums[i].length()-1){
                    chooseWhich=Integer.valueOf(String .valueOf(sNums[i].charAt(sNums[i].length()-1)));
                }else{
                    chooseWhich=Integer.valueOf(String .valueOf(sNums[i].charAt(j)));
                }
                natureSort[chooseWhich].add(sNums[i]);
            }
            //遍历桶回写
            int numsIndex=0;
            for(int k=0;k<natureSort.length;k++){
                for(String s:natureSort[k]){
                    sNums[numsIndex++]=s;
                }
                natureSort[k].clear();
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String s:sNums){
            sb.append(s);
        }
        return sb.toString();

        //每一位排序怎么做？放桶！


        //第一位相同的位数不通的两个数，算到短的长度之后，长的后面每一位与短的最后一位比较。

        //基数排序改造？

        //怎么排序？
        //如果为0则比最后一位



    }
}
