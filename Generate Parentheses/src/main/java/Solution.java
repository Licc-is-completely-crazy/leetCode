import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) throws InterruptedException {
        Solution solution=new Solution();
//        System.out.println(
                solution.generateParenthesis(10);
//        );
    }
    public List<String> generateParenthesis(int n) throws InterruptedException {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) throws InterruptedException {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            System.out.println(cur.toString());
//            Thread.sleep(50);
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
            System.out.println(cur.toString());
//            Thread.sleep(50);
        }
        if (close < open) {
            cur.append(')');
            System.out.println(cur.toString());
//            Thread.sleep(50);
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
            System.out.println(cur.toString());
//            Thread.sleep(50);
        }
    }
}