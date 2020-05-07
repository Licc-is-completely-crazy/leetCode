import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0){
            return "";
        }
        StringBuilder sb=new StringBuilder("");
        char[] characters=strs[0].toCharArray();
        //找最小长度
        int minLength=strs[0].length();
        for (String s:strs){
            if (minLength>s.length()){
                minLength=s.length();
            }
        }

        Map<Integer,char[]> cache=new HashMap<Integer, char[]>();
        for (int k=0;k<strs.length;k++){
            cache.put(k,strs[k].toCharArray());
        }

        for (int i=0;i<minLength;i++){
            for (int j=1;j<strs.length;j++){
               char[] current=cache.get(j);
               if (current[i]!=characters[i]){
                   return sb.toString();
               }
            }
            sb.append(characters[i]);
        }
        return sb.toString();
    }
}
