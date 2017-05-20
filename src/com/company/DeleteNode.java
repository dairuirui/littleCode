package com.company;

/**
 * Created by dai on 2017/5/18.
 */


public class DeleteNode {//在O(1)时间内删除链表节点
    static class ListNode{//内部类
        int value;
        ListNode next;
        ListNode(int x) { value = x; }
        ListNode(){};
    }

    public static void main(String[] args){
        ListNode head=new ListNode();
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        head.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=null;

        ListNode list=deleteNode(head, listNode1);
        if(list != null){
            ListNode p=list.next;
            while(p != null){
                System.out.println(p.value);
                p=p.next;
            }
        }
    }

    //1.如果待删除节点不是最后一个节点，就用他的next节点的value覆盖它的value，然后删掉它的next节点。
    //2.如果是最后一个节点，还是老老实实的顺序遍历吧。
    public static ListNode deleteNode(ListNode head, ListNode d){
        if(head==null || head.next==null || d==null || d==head)
            return head;
        if(d.next==null){//最后一个节点
            ListNode p=head;
            while(p.next != d)
                p=p.next;
            p.next=d.next;
        }else{
            d.value=d.next.value;
            d.next=d.next.next;
        }
        return head;
    }

}

