package com.company;

/**
 * Created by dai on 2017/5/20.
 */
public class FindKthToTail {
    //����һ����������������е�����k����㡣

    //idea:����ָ�룬��һ��ָ������K��;����³���ԣ�ע���ж������Ƿ����Ҫ��
    //time com:O(n),,space com:O(1)
    //����ʱ�䣺38m,,ռ���ڴ棺654k
    /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
    public ListNode indKthToTail(ListNode head,int k) {
        if(k <= 0) return null;//k����
        if(head == null) return null;//����Ϊ��

        ListNode p1=head, p2;
        //p1���K��
        int i;
        for(i=0; i<k; i++){
            if(p1 != null)
                p1 = p1.next;
            else break;
        }
        if(i<k)//������K���ڵ�
            return null;

        p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }

}
