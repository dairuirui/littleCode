package com.company;

import java.util.Stack;

/**
 * Created by dai on 2017/4/8.
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        //push时就记录下最小值
        stack.push(x);
        if(x < min)
            min = x;
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(!stack.isEmpty()){
            int min = Integer.MAX_VALUE;
            while(!stack.isEmpty()){
                temp.push(stack.pop());
                if(temp.peek() < min)
                    min = temp.peek();
            }
            while(!temp.isEmpty())
                stack.push(temp.pop());
            return min;
        }
        return ;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
