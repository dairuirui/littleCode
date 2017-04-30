package com.company;

/**
 * Created by dai on 2017/4/30.
 */
public class ClimbStairs {
    public static void main(String args[]){
        System.out.print(climbStairs(44));
    }

    /*
    * ��f(n)��ʾ������n ��¥�ݵķ�������Ϊ��������n��¥�ݣ�����������ѡ��
      ? �ӵ�f(n-1)��ǰ��1����
      ? �ӵ�f(n-2)��ǰ��2����
      ��f(n)��д�ɣ�f(n) = f(n-1) + f(n-2)
    * */

    //�ݹ飨��̬�滮�㷨DP�������ںܶ��ظ�������
    //��ʱ
//    public static int climbStairs(int n){
//        if(n<0) return 0;
//        return Fibonacci(n);
//    }
//    public static int Fibonacci(int n){
//        //��쳲������ĳ�ʼֵ��һ��
//        if(n==1) return 1;
//        else if(n==2) return 2;
//        else return Fibonacci(n-1)+Fibonacci(n-2);
//    }

    //���η������԰�¥�ݿ�һ�룬��һ��ķ�����*��һ��ķ������ǲ��Ǿ͵������մ��أ���ֹ���������������������¥�ݵ����Ӵ�����������ʱ�����
    //runtime:0ms,beats 17.41 %
//    public static int climbStairs(int n){
//        if(n<=3) return n;
//        //nΪż��
//        int leftCount=climbStairs(n/2);
//        int rightCount=leftCount;
//        int leftCount2=climbStairs(n/2-1);
//        int rightCount2=leftCount2;
//        if(n%2 == 1){//nΪ����
//            rightCount=leftCount+leftCount2;//climbStairs(n/2+1)
//            rightCount2=leftCount;
//        }
//        return leftCount*rightCount + leftCount2*rightCount2;
//    }

    //ѭ�����������ϼ��㣬����F(0)��f(1)����f(2),Ȼ����f(1)��f(2)����f(3)......
    //time com:O(n), space com:O(1)
    //runtime:0ms,beats 17.41 %
    public static int climbStairs(int n){
        if(n<=2) return n;
        int fib1=1, fib2=2, fibN=0;
        for(int i=3; i<=n; i++){
            fibN=fib1+fib2;
            fib1=fib2;
            fib2=fibN;
        }
        return fibN;
    }

}
