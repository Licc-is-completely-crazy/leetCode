/**
 * 1.已知 a,b 两个整数组成的数组，每次能够把 a或者 b 里面的数 +1或者 −1，问最少需要多少次能够使 a 的最大值小于等于 b 的最小值?
 * 例: a=[1,2,3], b=[2,7,8];
 * 答: 1 次，把 a 中的 3 减—，最大值为 2，小于等于 b 的最小值。
 *
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] a=new int[]{1,5,8};
        int[] b=new int[]{2,7,8};
        System.out.println(solution.times(a,b));

    }

    private int times(int[] a,int[] b){
        if (a==null||a.length==0||b==null||b.length==0){
            return -1;
        }
        int max4a=a[0];
        int min4b=b[0];
        //找a的最大值
        for (int tem:a){
            if (tem>max4a){
                max4a=tem;
            }
        }
        //找b的最小值
        for(int tem:b){
            if (tem<min4b){
                min4b=tem;
            }
        }
        if (max4a<min4b){
            return 0;
        }
        //找a中min4b<aa<max4a的最小值
        int aa=max4a;
        for (int tem:a){
            if (min4b<tem&&tem<aa){
                aa=tem;
            }
        }
        //找b中min4b<bb<aa的最大值
        int bb=min4b;
        for (int tem:b){
            if (bb<tem&&tem<aa){
                bb=tem;
            }
        }
        if (max4a-aa>0||min4b-bb>0){
            return (max4a-aa)+(min4b-bb)+2*(aa-bb);
        }
        return max4a-min4b;
    }
}
