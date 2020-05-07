import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));

    }
    public static int romanToInt(String s) {
        //降序入栈，逆序出堆栈
        Map<Character,Integer> representMap=new HashMap();
        representMap.put('I',1);
        representMap.put('V',5);
        representMap.put('X',10);
        representMap.put('L',50);
        representMap.put('C',100);
        representMap.put('D',500);
        representMap.put('M',1000);
        Stack<Integer> stack=new Stack();
        if(s!=null&&s.length()!=0){

            char[] charArray= s.toCharArray();
            for (char c:charArray){
                Integer current=representMap.get(c);
                if (stack.isEmpty()){
                    stack.push(current);
                    continue;
                }
                Integer before=stack.peek();
                if(before>=current){
                    stack.push(current);
                }else if(before!=null&&before<current){
                    before=stack.pop();
                    current= current-before;
                    stack.push(current);
                }
            }
            int sum=0;
            while (!stack.isEmpty()){
                sum=sum+stack.pop();
            }
            return sum;
        }
        return 0;

    }
}
