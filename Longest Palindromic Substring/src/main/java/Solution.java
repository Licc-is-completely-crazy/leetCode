import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome("anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgoobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlplnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuizqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg"));
    }

    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){
            return "";
        }
        char[] chars=s.toCharArray();
        String[] result=new String[chars.length];
        for (int i=0;i<chars.length;i++){
            if (i==0){
                result[i]=String.valueOf(chars[i]);
            }else {
                result[i]=maxString(result[i-1],getLongstPalindromicContanslast(chars,i));
            }

        }
        return result[chars.length-1];
    }

    //TODO 题目理解错误：理解成了重复出现最长子串
    private String getLongstContanslast(char[] cr,int last){
        if (last==0){
            return String.valueOf(cr[last]);
        }
        List<Integer> list=new ArrayList<Integer>();
        for (int i=0;i<last;i++){
            if (cr[i]==cr[last]){
                list.add(i);
            }
        }
        if (list.size()==0){
            return String.valueOf(cr[last]);
        }
        for (int i=1;;i++){
            int count=0;
            for (Integer j:list){
                if (j-i>=0&&cr[j-i]==cr[last-i]){
                    count++;
                }
            }
            if (count==0){
                return String.valueOf(cr,last-i+1,i);
            }
        }
    }

    private String maxString(String s1,String s2){
        if (s1.length()>s2.length()){
            return s1;
        }
        return s2;
    }

    private String getLongstPalindromicContanslast(char[] cr,int last){
        if (last==0){
            return String.valueOf(cr[last]);
        }
        String result=String.valueOf(cr[last]);
        for(int i=0;i<last;i++){
           String now=String.valueOf(cr,i,last-i+1);
            if (isPalindromic(now)){
                return now;
            }
        }
        return result;
    }

    private  boolean isPalindromic(String s){
       char cr[]= s.toCharArray();
       int last=cr.length-1;
       for (int i=0;i<cr.length;i++){
           if (cr[i]!=cr[last-i]){
               return false;
           }
       }
       return true;
    }
}
