package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 2017/5/28.
 */
public class PrintFromTopToBottom {

    /*题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    * */
    //本题扩展：广度优先遍历一个有向图，同样需要用到队列，
    //idea：用队列保存子节点，遍历队列中的所有节点保证打印顺序
    //time com:O(n),space com:O(n)
    //运行时间：34ms,占用内存：636k
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            list.add(cur.val);
            if(cur.left!=null)
                queue.add(cur.left);
            if(cur.right!=null)
                queue.add(cur.right);
        }

        return list;
    }
}
