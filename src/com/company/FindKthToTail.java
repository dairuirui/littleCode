package com.company;

/**
 * Created by dai on 2017/5/20.
 */
public class FindKthToTail {
    //输入一个链表，输出该链表中倒数第k个结点。

    //idea:两个指针，第一个指着先走K步;代码鲁棒性（注意判断输入是否符合要求）
    //time com:O(n),,space com:O(1)
    //运行时间：38m,,占用内存：654k
    /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
    public ListNode indKthToTail(ListNode head,int k) {
        if(k <= 0) return null;//k非正
        if(head == null) return null;//链表为空

        ListNode p1=head, p2;
        //p1向后K步
        int i;
        for(i=0; i<k; i++){
            if(p1 != null)
                p1 = p1.next;
            else break;
        }
        if(i<k)//链表不足K个节点
            return null;

        p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

}
