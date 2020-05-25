import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static List<String> generateParenthesis(int n) {
        Set<String> result=new HashSet<String>();
        char[] cs=new char[2*n];
        generateAll('(',0,cs,result);
        generateAll(')',0,cs,result);
        return new ArrayList<String>(result);
    }
    public static void generateAll(char c,int length,char[] last,Set result){
        if(last.length==length){
            if(valid(last)){
                result.add(new String(last));
            }
            return;
        }
        last[length]=c;
        length++;
        generateAll('(',length,last,result);
        generateAll(')',length,last,result);

    }
    public static void main(String[] args) {
        long begin=System.currentTimeMillis();
        System.out.println(generateParenthesis(3));
        System.out.println(System.currentTimeMillis()-begin);
    }

    public static boolean valid(char[] last){
        int tools=0;
        for (char c:last){
            if (c=='('){
                ++tools;
            }
            if (c==')'){
                --tools;
            }
            if (tools<0){
                return false;
            }
        }
        if (tools==0){
            return true;
        }
        return false;
    }
}
