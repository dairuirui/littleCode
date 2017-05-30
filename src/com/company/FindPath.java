import java.util.ArrayList;
import java.util.Stack;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    //题目：二叉树中和为某一值得路径

    //idea：前序遍历，递归
    //运行时间：42ms。占用内存：654k
   
    public ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();
        find(root, target, 0, stack);
        
        return list;
    }
    public void find(TreeNode node, int target, int sum, Stack<TreeNode> stack){
        if(node==null) return;
  
        if(node.left==null && node.right==null){
            if(sum+node.val==target){
                ArrayList<Integer> path=new ArrayList<>();
                for(TreeNode n:stack){
                    path.add(n.val);
                }
                path.add(node.val);
                list.add(path);
            }
            return;
        }else{
            stack.push(node);
            find(node.left, target, sum+node.val, stack);
            find(node.right, target, sum+node.val, stack);
            stack.pop();
            return;
        }
    }
}