import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("(])"));

    }
    public static boolean isValid(String s) {
        if(s==null){
            return false;
        }
        if(s.length()==0){
            return true;
        }
        char[] cs=s.toCharArray();
        Stack<Character> stack=new Stack();
        for(char c:cs){
            if(stack.isEmpty()&&(c==')'||c=='}'||c==']')){
                return false;
            }
            if(c==')'){
                char top=stack.peek();
                if(top=='('){
                    stack.pop();
                    continue;
                }
            }
            if(c=='}'){
                char top=stack.peek();
                if(top=='{'){
                    stack.pop();
                    continue;
                }
            }
            if(c==']'){
                char top=stack.peek();
                if(top=='['){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);

        }
        return stack.isEmpty();
    }
}
