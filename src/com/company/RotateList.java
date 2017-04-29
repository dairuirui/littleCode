package com.company;

/**
 * Created by dai on 2017/4/28.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RotateList {

    public static void main(String[] args){
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        listNode1.next=listNode2;
        listNode2.next=null;
        ListNode rotateList=rotateRight(listNode1, 2);
        while(rotateList != null){
            System.out.println(rotateList.val);
            rotateList=rotateList.next;
        }
    }

    //idea:前半部分链表直接插入尾部
    //time complexity:O(n), space complexity:O(1)
    //runtime:17ms
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return null;
        int length=1;
        ListNode end=head;
        while(end.next != null){//计算链表长度
            length++;
            end=end.next;
        }
        ListNode cur=head;
        for(int i=1; i<length-k%length; i++){//cur指针移到第length-k%length个节点
            cur=cur.next;
        }
        //前半部分直接插入尾部
        end.next=head;
        head=cur.next;
        cur.next=null;
        return head;
    }

    //

}
