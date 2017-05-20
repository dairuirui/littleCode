package com.company;

/**
 * Created by dai on 2017/5/20.
 */
public class MergeTwoSortedLists {
    //Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

    //±éÀú
    //time com:O(),,space com:O(1)
    //Runtime: 15 ms,, beats  beats 75.15 %
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode p1=l1, p2=l2;
        ListNode l3, p3;
        if(p1.val < p2.val){
            l3=p3=p1;
            p1=p1.next;
        }else{
            l3=p3=p2;
            p2=p2.next;
        }

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p3.next=p1;
                p3=p3.next;
                p1=p1.next;
            }else{
                p3.next=p2;
                p3=p3.next;
                p2=p2.next;
            }
        }
        if(p1 == null)
            p3.next=p2;
        else
            p3.next=p1;

        return l3;
    }

    //µİ¹é
    //time com:O(n), space com:O(n)
    //Runtime: 15 ms, beats 75.15 %
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode p1=l1, p2=l2;
        ListNode l3;
        if(p1.val < p2.val){
            l3=p1;
            l3.next=mergeTwoLists(p1.next, p2);
        }else{
            l3=p2;
            l3.next=mergeTwoLists(p1, p2.next);
        }

        return l3;
    }
}
