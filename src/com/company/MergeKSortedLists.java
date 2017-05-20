package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by dai on 2017/5/20.
 */
public class MergeKSortedLists {
    //Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    //idea:递归和两个有序数组的合并
    //递归时间复杂度是O(logn)，合并两个链表的时间复杂度是O（n）,则总的时间复杂度大概是O（nlogn）
    //Runtime: 17 ms， beats 73.47 %
    public ListNode mergeKLists1(ListNode[] lists) {//递归
        if(lists.length==0 || lists==null) return null;
        return mergeListsMToN(lists, 0, lists.length-1);
    }
    public ListNode mergeListsMToN(ListNode[] lists, int m, int n){
        if(m == n)
            return lists[m];
        if(m+1 == n)
            return mergeTwoLists(lists[m], lists[n]);
        else{
            ListNode l1=mergeListsMToN(lists, m, (m+n)/2);
            ListNode l2=mergeListsMToN(lists, (m+n)/2+1, n);
            return mergeTwoLists(l1, l2);
        }
    }
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

    //idea：使用小项堆PriorityQueue
    //Runtime: 24 ms, beats 27.35 %
    public ListNode mergeKLists2(ListNode[] lists){
        if(lists.length==0 || lists==null) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        //加入所有链表的第一个节点,非空
        for(ListNode node:lists){
            if(node != null)
                queue.add(node);
        }
        ListNode start=new ListNode(0);
        ListNode p=start;
        while(!queue.isEmpty()){
            //边取边加入
            p.next=queue.poll();
            p=p.next;
            if(p.next != null){
                queue.add(p.next);
            }
        }
        p.next=null;
        return start.next;
    }
}
