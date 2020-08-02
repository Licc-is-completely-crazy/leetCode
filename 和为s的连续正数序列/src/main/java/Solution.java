import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.findContinuousSequence(9);
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> result=new ArrayList();
        for(int i=target;i>1;i--){
            Integer min=findNx(i,target);
            if(min!=null){
                int[] s=new int[i];
                for(int j=0; j<i;j++){
                    s[j]=min+j;
                }
                result.add(s);
            }
        }
        int[][] s=new int[result.size()][];
        for (int k=0;k<result.size();k++){
            s[k]=result.get(k);
        }
        return s;
    }
    public Integer findNx(int n,int target){
        int part=(target-n+1)-(n*n-3*n+2)/2;
        int left=part%n;
        int res=part/n;

        if(left==0&&res>0){
            return part/n;
        }
        return null;

    }
}
