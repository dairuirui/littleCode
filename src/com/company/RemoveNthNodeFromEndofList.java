package com.company;

/**
 * Created by dai on 2017/5/20.
 */
public class RemoveNthNodeFromEndofList {
    //ɾ�������е�����n���ڵ�

    //idea:����ָ�룬��һ��ָ������K��;����³���ԣ�ע���ж������Ƿ����Ҫ��
    //���ƣ�FindKthToTail
    //time com:O(n),,space com:O(1)
    //Runtime: 16 ms����beats 46.59 %
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head==null || n<=0) return head;

        if(n == 1){//ɾ�����һ���ڵ�
            if(head.next == null)
                return null;
            //��ͷ��ʼ��������ɾ�����һ���ڵ�
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
        if(i < n)//����n���ڵ�
            return head;

        slow=head;
        while(fast != null){
            fast=fast.next;
            slow=slow.next;
        }
        //�ı����ݷ�ʽɾ��slow�ڵ㣬��ͷ�ڵ�Ҳ���ã���β�ڵ㲻����
        slow.val=slow.next.val;
        slow.next=slow.next.next;
        return head;
    }

    //�Ľ���������֮ǰ��ӽڵ㣬����ɾ���ڵ�
    //time com:O(n),,space com:O(1)
    //Runtime: 14 ms����beats  86.70 %
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null || n<=0) return head;

        ListNode start = new ListNode(0);//������֮ǰ��ӽڵ㣬����ɾ��ͷ�ڵ�
        start.next = head;
        ListNode fast=start, slow=start;

        int i;
        for(i=1; i<=n+1; i++){
            if(fast != null)
                fast=fast.next;
            else
                break;
        }
        if(i < n)//����n���ڵ�
            return head;

        while(fast != null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return start.next;
    }

}
