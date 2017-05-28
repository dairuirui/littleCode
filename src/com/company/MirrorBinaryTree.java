package com.company;

import java.util.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 2017/5/23.
 */
public class MirrorBinaryTree {
    //��һ�����������Ķ�����������任ΪԴ�������ľ���

    //����һ
    //idea���������з�Ҷ�ӽڵ�������ӽڵ�
    //����ʱ�䣺38ms��ռ���ڴ棺654k
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

    //������
    //idea��ѭ����ջ��ע�������룩
    //����ʱ�䣺34ms��ռ���ڴ棺692k
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


    //������ж϶������Ƿ�Ϊ����Գ�

    //����һ:
    //idea���ݹ飬�Ա��������Ƿ�Գ�
    //Runtime: 1 ms�� beats 25.96 %
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

    //��������
    //idea��ѭ��������кͳ����У�ע�������������룩
    //Runtime: 2 ms��beats 14.77 %
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
