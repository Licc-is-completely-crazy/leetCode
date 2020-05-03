import java.util.Iterator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int res=reverse(-21);
        System.out.println(res);
    }


    public static int reverse(int x) {
        char[] chars=String.valueOf(x).toCharArray();
        Stack<Character> stack=new Stack();
        //reverse
        for (char c:chars){
            if (c>=48&&c<=57){
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        Iterator it = stack.iterator();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 48 && chars[i] <= 57) {
                chars[i] = stack.pop();
            }
        }
        try {
          return Integer.valueOf(new String(chars));
        }catch (Exception e){
            return 0;
        }
    }

}
