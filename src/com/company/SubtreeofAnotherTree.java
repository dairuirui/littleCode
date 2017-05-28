package com.company;

/**
 * Created by dai on 2017/5/23.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class SubtreeofAnotherTree {
     /*//（剑指offer）输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    //idea:递归
    //运行时间：37ms，占用内存：654k
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1!=null && root2!=null){
            if(root1.val == root2.val)
                result=isSubtree(root1, root2);
            if(!result)
                result=HasSubtree(root1.left, root2);
            if(!result)
                result=HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }*/

    /*Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with
    a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
    The tree s could also be considered as a subtree of itself.*/
    //Runtime: 30 ms，beats 49.28 %
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result=false;
        if(s!=null && t!=null){
            if(s.val == t.val)
                result=hasSubtree(s, t);
            if(!result)
                result=isSubtree(s.left, t);
            if(!result)
                result=isSubtree(s.right, t);
        }
        return result;
    }

    public boolean hasSubtree(TreeNode root1, TreeNode root2){
        if(root1==null && root2 == null)
            return true;
        if(root1 == null || root2==null)
            return false;
        if(root1.val != root2.val)
            return false;
        return hasSubtree(root1.left, root2.left) && hasSubtree(root1.right, root2.right);
    }
}
