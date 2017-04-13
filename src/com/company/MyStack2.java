package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 2017/4/8.
 */
//使用两个队列，
//Runtime: 140 ms
public class MyStack2 {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack2() {

    }

    /** Push element x onto stack. */
    //关键
    public void push(int x) {
        //后加元素在最前面
        if(queue1.isEmpty()){
            queue1.add(x);
            while(!queue2.isEmpty())
                queue1.add(queue2.poll());
        }else{
            queue2.add(x);
            while(!queue1.isEmpty())
                queue2.add(queue1.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!queue1.isEmpty())
            return queue1.poll();
        else
            return queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        if(!queue1.isEmpty())
            return queue1.peek();
        else
            return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
