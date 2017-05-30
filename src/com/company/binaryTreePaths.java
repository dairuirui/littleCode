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

    /*//方法一： 
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
    }*/

    //方法二：
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

    //先序遍历二叉树，string参数存当前路径，list参数存已遍历路径
    //Runtime: 18 ms， beats 59.19 % 
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root!=null) addPath(root, "", list);
        return list;
    }
    public void addPath(TreeNode root, String path, List list){
        if(root.left==null && root.right==null)
            list.add(path+root.val);
        if(root.left!=null)
            addPath(root.left, path+root.val+"->", list);
        if(root.right!=null)
            addPath(root.right, path+root.val+"->", list);
    }

}