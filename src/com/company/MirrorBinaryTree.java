package com.company;

import java.util.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 2017/5/23.
 */
public class MirrorBinaryTree {
    //题一、操作给定的二叉树，将其变换为源二叉树的镜像。

    //方法一
    //idea：交换所有非叶子节点的两个子节点
    //运行时间：38ms，占用内存：654k
    public void mirror(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null)
            mirror(root.left);
        if(root.right!=null)
            mirror(root.right);
    }

    //方法二
    //idea：循环，栈（注意库的引入）
    //运行时间：34ms，占用内存：692k
    public class Solution {
        public void Mirror(TreeNode root) {
            if(root==null) return;

            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(root);
            while(!s.isEmpty()){
                TreeNode node = s.pop();
                if(node.left!=null || node.right!=null){
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
                if(node.left != null)
                    s.push(node.left);
                if(node.right != null)
                    s.push(node.right);
            }
        }
    }


    //题二、判断二叉树是否为镜像对称

    //方法一:
    //idea：递归，对比两棵树是否对称
    //Runtime: 1 ms， beats 25.96 %
    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        if(root.left==null && root.right==null) return true;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null) return true;
        if(node1==null || node2==null) return false;
        if(node1.val!=node2.val) return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    //方法二：
    //idea：循环，入队列和出队列（注意两个包的引入）
    //Runtime: 2 ms，beats 14.77 %
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        while(q.size() > 1){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left==null && right==null) continue;
            if(left==null || right==null) return false;
            if(left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
