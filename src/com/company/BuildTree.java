package com.company;

/**
 * Created by dai on 2017/4/8.
 */
public class BuildTree {
    public static void main(String[] args){
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        System.out.println(buildTree(preorder, inorder).right.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildCore(0, 0, inorder.length-1, preorder, inorder);
    }
    //ตÝน้
    public static TreeNode buildCore(int prestart, int instart, int inend, int[] preorder, int[] inorder){
        if(prestart > preorder.length-1 || instart > inend)
            return null;

        TreeNode root = new TreeNode(preorder[prestart]);
        int inindex = 0; //current root in inorder
        for(int i = instart; i <= inend; i++){
            if(inorder[i] == root.val)
                inindex = i;
        }

        root.left = buildCore(prestart+1, instart, inindex-1, preorder, inorder);
        root.right = buildCore(prestart+inindex-instart+1, inindex+1, inend, preorder, inorder);
        return root;
    }
}
