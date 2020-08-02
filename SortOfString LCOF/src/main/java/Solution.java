import java.util.*;

public class Solution {
    List<String> res = new LinkedList<>();
    char[] c;

    public static void main(String[] args) {
        Solution solution=new Solution();
//        solution.permutation("zg");

        solution.best("abcde");
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


    public String[] best(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            System.out.println(String.valueOf(c));
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


}
