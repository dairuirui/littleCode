package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 2017/5/28.
 */
public class PrintFromTopToBottom {

    /*��Ŀ���������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
    * */
    //������չ��������ȱ���һ������ͼ��ͬ����Ҫ�õ����У�
    //idea���ö��б����ӽڵ㣬���������е����нڵ㱣֤��ӡ˳��
    //time com:O(n),space com:O(n)
    //����ʱ�䣺34ms,ռ���ڴ棺636k
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
