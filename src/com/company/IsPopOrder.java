package com.company;

/**
 * Created by dai on 2017/5/28.
 */
import java.util.Stack;
public class IsPopOrder {
    /*��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
    ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
    ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
    * */
    //idea�������һ�����������ָպ���ջ��Ԫ�أ�ֱ�ӵ����������һ��Ҫ���������ֲ���ջ������ѹ�������л�û����ջ��һ��������ѹջ��
    //����������ֶ���ջ�˻�û���ҵ���һ��Ҫ������Ԫ�أ���ô�����в�������һ����������
    //time com:O(n),space com:O(n)
    //����ʱ�䣺35ms,ռ���ڴ棺528k
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
