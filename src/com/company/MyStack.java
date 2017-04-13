package com.company;

import java.nio.charset.IllegalCharsetNameException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by dai on 2017/4/8.
 */

//ʹ��һ�����У���Ϊ�������к������൱��һ������

//Runtime: 109 ms
public class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    //�ؼ�
    public void push(int x) {
        queue.add(x);
        //���Ԫ������ǰ��
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