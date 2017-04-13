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

    //栈，“后进先出”  时间41ms，内存654k
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

        return arrayList;// 输入为{}时，输出为[],,,所以不要先判断if(listNode == null),这样会出错
    }

    //递归 运行时间：33ms,占用内存：528k
    //问题：函数调用的层级很深，有可能导致函数调用栈溢出
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode != null){
            arrayList = printListFromTailToHead2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
