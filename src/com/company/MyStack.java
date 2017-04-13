package com.company;

import java.nio.charset.IllegalCharsetNameException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 2017/4/8.
 */

//使用一个队列，因为两个队列合起来相当于一个队列

//Runtime: 109 ms
public class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    //关键
    public void push(int x) {
        queue.add(x);
        //后加元素在最前面
        while (queue.peek() != x)
            queue.add(queue.remove());
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
