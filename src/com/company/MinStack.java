package com.company;

/**
 * Created by dai on 2017/5/28.
 */
import java.util.Stack;
public class MinStack {
    public static void main(String args[]){
        push(3);
        System.out.println(getMin());
        push(4);
        System.out.println(getMin());
        push(2);
        System.out.println(getMin());
        push(1);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        push(0);
        System.out.println(getMin());
    }
    /*//����һ����������ջ������ջdata������ݣ�����ջmin���ÿһ��֮�����Сֵ
    //Runtime: 119 ms��beats 54.15 %
    public static Stack<Integer> data=new Stack<Integer>();
    public static Stack<Integer> min=new Stack<Integer>();

    public static void push(int x) {
        data.push(x);
        if(min.isEmpty() || x<=min.peek()){
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }

    public static void pop() {
        if(!data.isEmpty() && !min.isEmpty()){
            data.pop();
            min.pop();
        }
    }

    public static int top() {
        return data.peek();
    }

    public static int getMin() {
        return min.peek();
    }
*/
    //��������ʹ��һ��ջ����ջ�а�����Сֵ��Ϣ
    //��ջ��Сֵ֮ǰ���Ȱ�ԭ������Сֵ��ջ��
    //��ջ��Сֵ�󣬰���Сֵ���ԭ������Сֵ
    //�Ӷ����ﵽ��¼��Сֵ��Ŀ��
    //Runtime: 114 ms,beats 66.26 %
    static Stack<Integer> stack=new Stack<>();
    static int min=Integer.MAX_VALUE;
    public static void push(int x) {
        if(x<=min) {stack.push(min); min=x;}
        stack.push(x);
    }
    public static void pop() {
        if(stack.peek()==min){ stack.pop(); min=stack.pop(); }
        else stack.pop();
    }
    public static int top() {
        return stack.peek();
    }
    public static int getMin() {
        return min;
    }
}
