/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //题目：Binary Tree Paths
    //Given a binary tree, return all root-to-leaf paths. 
    //idea：二叉树的先序遍历，栈，循环
    //Runtime: 21 ms, beats 25.20 % 
    public List<String> list=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return list;
        
        Stack<Integer> stack=new Stack<>();
        addPath(root, stack);
        
        return list;
    }
    public void addPath(TreeNode root, Stack<Integer> stack){
        if(root==null) return;
        
        if(root.left==null && root.right==null){
            StringBuffer path=new StringBuffer();
            for(int i:stack)
                path.append(i+"->");
            path.append(root.val);
            list.add(path.toString());
            return;
        }else{
            stack.push(root.val);
            addPath(root.left, stack);
            addPath(root.right, stack);
            stack.pop();
            return;
        }
    }
}