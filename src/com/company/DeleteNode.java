package com.company;

/**
 * Created by dai on 2017/5/18.
 */


public class DeleteNode {//��O(1)ʱ����ɾ������ڵ�
    static class ListNode{//�ڲ���
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

    //1.�����ɾ���ڵ㲻�����һ���ڵ㣬��������next�ڵ��value��������value��Ȼ��ɾ������next�ڵ㡣
    //2.��������һ���ڵ㣬��������ʵʵ��˳������ɡ�
    public static ListNode deleteNode(ListNode head, ListNode d){
        if(head==null || head.next==null || d==null || d==head)
            return head;
        if(d.next==null){//���һ���ڵ�
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

