import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
    }
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack=new Stack();
        //层序遍历检查对称性
        if (root==null){
            return true;
        }
        List<TreeNode> list=new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()){
          if (!checkMirror(list)){
              return false;
          }
          list.stream().filter(Objects::nonNull);
          if (list.isEmpty()){
              break;
          }
          List<TreeNode> newList=new ArrayList<>();
          for (TreeNode treeNode:list){
              if (treeNode!=null){
                  newList.add(treeNode.left);
                  newList.add(treeNode.right);
              }
          }
          list.clear();
          list=newList;
        }
        return true;
    }

    private boolean checkMirror(List<TreeNode> list){
       for (int i=0;i<list.size()/2;i++){
          if (list.get(i)==list.get(list.size()-1-i)||list.get(i)!=null&&list.get(list.size()-1-i)!=null&&list.get(i).val==list.get(list.size()-1-i).val){
              continue;
          }else{
              return false;
          }
        }
       return true;
    }

}
/**
 * Definition for a binary tree node.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

