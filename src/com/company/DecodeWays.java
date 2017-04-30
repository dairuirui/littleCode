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
回想爬楼梯问题一样，number[i] = number[i-1] + number[i-2]
但不同的是本题有多种限制：
第一：s[i]不能是0，如果s[i]是0的话，number[i]就只能等于number[i-2]
第二，s[i-1,i]中的第一个字符不能是0，而且Integer.parseInt(s.substring(i-1,i+1))获得的整数必须在10到26之间。
    * */
    //循环：从下往上计算，首先F(0)和f(1)计算f(2),然后游f(1)和f(2)计算f(3)......
    //time com:O(n), space com:O(1)
    //runtime:6ms,beats 17.18 %
    public static int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;
        int fib1=1, fib2=1, fibN=0;
        int num;
        for(int i=1; i<s.length(); i++){
            fibN=0;//每次清零

            num=Integer.parseInt(s.substring(i,i+1));
            //检查当前字符是否为'0',不为0表示可以代表一个字母
            if(num!=0) {
                fibN = fib2;
            }
            //检查当前字符与前一个字符的组合是否在‘10~26’
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
