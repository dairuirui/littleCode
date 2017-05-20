package com.company;

/**
 * Created by dai on 2017/5/20.
 */
public class ReverseLinkedListII {
    //Reverse a linked list from position m to n. Do it in-place and in one-pass.

    //time com:O(n),, space com:O(1)
    //Runtime: 0 ms，，beats 17.56%  （额外考虑了代码的鲁棒性，所以效率比其他方案低）
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //头插法,同时考虑代码鲁棒性(输入有效性)
        if(head == null || m <= 0 || m >= n) return head;

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode nodeM, preM, next, temp;
        preM = start;
        int i;
        for(i=1; i<m; i++){
            if(preM.next != null)
                preM = preM.next;
            else break;
        }
        if(i<m)//链表长度小于m-1
            return head;
        nodeM=preM.next;
        if(nodeM == null) //链表只有m-1个节点
            return head;

        for(int j=m+1; j<=n; j++){
            next=nodeM.next;
            if(next != null){
                nodeM.next=next.next;
                next.next=preM.next;
                preM.next=next;
            }else{
                break;
            }
        }
        return start.next;
    }
}
