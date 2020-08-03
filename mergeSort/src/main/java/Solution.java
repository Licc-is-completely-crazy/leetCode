import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
//       List<Integer> s= Arrays.asList(1,2,3,4);
//       Integer[] s2=new Integer[s.size()];
        int [] result= solution.sort( new int[]{2,2,3,431,2,341,4});
        for (int c:result){
            System.out.println(c);
        }

    }

    public int[] sort(int[] array){
        int length=array.length;
        int[] copy=new int[length];
        divide(0,length-1,array,copy);
        return array;
    }

    public void divide(int left,int right,int[] target,int[] copy) {
        if (left==right){
            return;
        }
        int mid=(left+right)/2;

        divide(left,mid,target,copy);
        divide(mid+1,right,target,copy);
        merge(left,mid,right,target,copy);
    }

    public void merge(int left,int mid,int right,int[] target,int[] copy){
        for (int i=left;i<=right;i++){
            copy[i]=target[i];
        }
        int s1=left,s2=mid+1,t=left;
        while (s1<=mid&&s2<=right){
            if (copy[s1]<=copy[s2]) {
                target[t++]=copy[s1++];
            }else {
                target[t++]=copy[s2++];
            }
        }
        while (s2<=right){
            target[t++]=copy[s2++];
        }
        while (s1<=mid){
            target[t++]=copy[s1++];
        }
    }
}
