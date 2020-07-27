import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.permutation("zg");

    }

    public String[] permutation(String s) {
        //回溯？
        List<String[]> res=new ArrayList();
        for(int i=1;i<=s.length();i++){
            String current=null;
            if(i<s.length()){
                current=s.substring(0,i);
            }else{
                current=s;
            }
            if(i==1){
                res.add(new String[]{current});
                System.out.println("第一个"+current);
                continue;
            }
            String[] preRes=res.get(i-2);
            char[] currents=current.toCharArray();
            char newChar=currents[i-1];
//            System.out.println(newChar);
            Set<String> currentRes=new HashSet<String>();
            System.out.println("preRes 长度"+preRes.length);
            for(String p:preRes){
                System.out.println("子串："+p);
                char[] temArray=p.toCharArray();

                for(int j=0;j<=p.length();j++){
                    StringBuilder sb=new StringBuilder();
                    for(int k=0;k<=p.length();k++){
//                        System.out.println("j的值"+j);
//                        System.out.println("k的值"+k);
                        if(j==k)
                            sb.append(newChar);
                        if (k < p.length())
                            sb.append(temArray[k]);
                        if(k==p.length()){
                            System.out.println("结果："+sb.toString());
                            currentRes.add(sb.toString());
                        }
                    }
                }
            }
            String[] currentArray = currentRes.toArray(new String[currentRes.size()]);
            res.add(currentArray);
        }
        System.out.println(res);
        return res.get(s.length()-1);

    }
}
