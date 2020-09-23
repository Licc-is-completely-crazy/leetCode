import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {

        // write code here
        ArrayList<ArrayList<Integer>> result=new ArrayList();
        if(root==null){
            return result;
        }

        ArrayList<TreeNode> list=new ArrayList();
        list.add(root);
        result.add((ArrayList<Integer>) list.stream().map(node->node.val).collect(Collectors.toList()));
        while(!list.isEmpty()){
            ArrayList<TreeNode> temp=new ArrayList();
            for(TreeNode t:list){
                if(t.left!=null){
                    temp.add(t.left);
                }
                if(t.right!=null){
                    temp.add(t.right);
                }
            }
            if(!temp.isEmpty()){
                result.add((ArrayList<Integer>)temp.stream().map(node->node.val).collect(Collectors.toList()));
            }
            list=temp;
        }
        return result;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
