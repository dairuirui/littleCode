package com.company;

/**
 * Created by dai on 2017/5/20.
 */
public class RemoveNthNodeFromEndofList {
    //删除链表中倒数第n个节点

    //idea:两个指针，第一个指着先走K步;代码鲁棒性（注意判断输入是否符合要求）
    //类似：FindKthToTail
    //time com:O(n),,space com:O(1)
    //Runtime: 16 ms，，beats 46.59 %
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head==null || n<=0) return head;

        if(n == 1){//删除最后一个节点
            if(head.next == null)
                return null;
            //从头开始遍历，并删除最后一个节点
            ListNode p=head;
            while(p.next.next != null)
                p=p.next;
            p.next=null;
            return head;
        }

        ListNode fast=head, slow;
        int i;
        for(i=0; i<n; i++){
            if(fast != null)
                fast=fast.next;
            else
                break;
        }
        if(i < n)//不足n个节点
            return head;

        slow=head;
        while(fast != null){
            fast=fast.next;
            slow=slow.next;
        }
        //改变内容方式删除slow节点，对头节点也适用，对尾节点不适用
        slow.val=slow.next.val;
        slow.next=slow.next.next;
        return head;
    }

    //改进：在链表之前添加节点，便于删除节点
    //time com:O(n),,space com:O(1)
    //Runtime: 14 ms，，beats  86.70 %
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null || n<=0) return head;

        ListNode start = new ListNode(0);//在链表之前添加节点，便于删除头节点
        start.next = head;
        ListNode fast=start, slow=start;

        int i;
        for(i=1; i<=n+1; i++){
            if(fast != null)
                fast=fast.next;
            else
                break;
        }
        if(i < n)//不足n个节点
            return head;

        while(fast != null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return start.next;
    }

}
