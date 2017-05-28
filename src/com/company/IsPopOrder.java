package com.company;

/**
 * Created by dai on 2017/5/28.
 */
import java.util.Stack;
public class IsPopOrder {
    /*题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
    但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    * */
    //idea：如果下一个弹出的数字刚好是栈顶元素，直接弹出；如果下一个要弹出的数字不在栈顶，把压入序列中还没有入栈下一个的数字压栈；
    //如果所有数字都入栈了还没有找到下一个要弹出的元素，那么该序列不可能是一个弹出序列
    //time com:O(n),space com:O(n)
    //运行时间：35ms,占用内存：528k
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if((pushA==null && popA==null)) return true;
        int popIndex=0, popLength=popA.length;
        int pushIndex=0, pushLength=pushA.length;
        if(pushLength==0 && popLength==0) return true;
        if(pushLength!=popLength) return false;

        Stack<Integer> stack=new Stack<>();
        stack.push(pushA[pushIndex++]);
        while(popIndex<popLength){
            if(popA[popIndex]==stack.peek()){
                int x=stack.pop();
                popIndex++;
            }else if(pushIndex<pushLength){
                stack.push(pushA[pushIndex++]);
            }else{
                break;
            }
        }
        if(popIndex==popLength) return true;
        else return false;
    }
}
