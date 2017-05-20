package com.company;

/**
 * Created by dai on 2017/5/20.
 */
public class ReverseLinkedList {
    //Reverse a singly linked list.

    //idea：将后面的节点一次插入头节点的前面
    //time com:O(n),, space com:O(1)
    //Runtime: 0 ms,,beats 37.47 %
    public ListNode reverseList(ListNode head) {
        //头插法
        if(head == null)
            return head;

        ListNode p=head.next;
        ListNode newHead=head;
        newHead.next=null;
        ListNode temp;
        while(p != null){
            temp=p.next;
            p.next=newHead;
            newHead=p;
            p=temp;
        }
        return newHead;
    }
}
