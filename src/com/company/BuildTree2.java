package com.company;

/**
 * Created by dai on 2017/4/8.
 */
public class BuildTree2 {
    public static void main(String[] args){
        int[] inorder = {4,6,8,10,12,14,16};
        int[] postorder = {4,8,6,12,16,14,10};
        System.out.println(buildTree(postorder, inorder).left.right.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildCore(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }

    //ตÝน้
    public static TreeNode buildCore(int postend, int instart, int inend, int[] inorder, int[] postorder){
        if(postend < 0 || instart > inend)
            return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int inindex = 0; //root index in inorder
        for(int i=instart; i<=inend; i++){
            if(inorder[i] == root.val)
                inindex = i;
        }
        root.right = buildCore(postend-1, inindex+1, inend, inorder, postorder);
        root.left = buildCore(postend-(inend-inindex)-1, instart, inindex-1, inorder, postorder);
        return root;
    }
}
