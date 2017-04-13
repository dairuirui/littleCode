package com.company;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by dai on 2017/4/8.
 */
public class PrintListFromTailToHead {
    public static void main(String[] args){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        ArrayList<Integer> arrayList = printListFromTailToHead2(one);
        System.out.println(arrayList);
    }

    //ջ��������ȳ���  ʱ��41ms���ڴ�654k
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr = listNode;
        while(curr!= null){
            stack.push(curr.val);
            curr = curr.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(!stack.isEmpty()){
            arrayList.add(stack.pop());
        }

        return arrayList;// ����Ϊ{}ʱ�����Ϊ[],,,���Բ�Ҫ���ж�if(listNode == null),���������
    }

    //�ݹ� ����ʱ�䣺33ms,ռ���ڴ棺528k
    //���⣺�������õĲ㼶����п��ܵ��º�������ջ���
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode != null){
            arrayList = printListFromTailToHead2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
