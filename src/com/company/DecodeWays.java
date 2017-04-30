package com.company;

/**
 * Created by dai on 2017/4/30.
 */
public class DecodeWays {
    public static void main(String args[]){
        String s="121";
        System.out.print(" "+numDecodings(s));
    }

    /*
������¥������һ����number[i] = number[i-1] + number[i-2]
����ͬ���Ǳ����ж������ƣ�
��һ��s[i]������0�����s[i]��0�Ļ���number[i]��ֻ�ܵ���number[i-2]
�ڶ���s[i-1,i]�еĵ�һ���ַ�������0������Integer.parseInt(s.substring(i-1,i+1))��õ�����������10��26֮�䡣
    * */
    //ѭ�����������ϼ��㣬����F(0)��f(1)����f(2),Ȼ����f(1)��f(2)����f(3)......
    //time com:O(n), space com:O(1)
    //runtime:6ms,beats 17.18 %
    public static int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;
        int fib1=1, fib2=1, fibN=0;
        int num;
        for(int i=1; i<s.length(); i++){
            fibN=0;//ÿ������

            num=Integer.parseInt(s.substring(i,i+1));
            //��鵱ǰ�ַ��Ƿ�Ϊ'0',��Ϊ0��ʾ���Դ���һ����ĸ
            if(num!=0) {
                fibN = fib2;
            }
            //��鵱ǰ�ַ���ǰһ���ַ�������Ƿ��ڡ�10~26��
            if(s.charAt(i-1)!='0'){
                num=Integer.parseInt(s.substring(i-1,i+1));
                if(num>=10 && num<=26){
                    fibN += fib1;
                }
            }
            fib1=fib2;
            fib2=fibN;
        }
        return fibN;
    }
}
