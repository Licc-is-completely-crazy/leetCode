import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int res=lengthOfLongestSubstring("adsadw");
        System.out.println(res);

    }

    public static  int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        char[] c=s.toCharArray();
        int maxLen=1;
        for (int i=0;i<s.length();i++){
            int everyTimeMax=1;
            char begin=c[i];
            map.put(begin,i);
            for (int j=i+1;j<s.length();j++){
                if (map.get(c[j])==null){
                    map.put(c[j],j);
                    ++everyTimeMax;
                }else{
                    break;
                }
            }
            map.clear();
            maxLen=maxLen<everyTimeMax?everyTimeMax:maxLen;
        }
        return maxLen;
    }
}
