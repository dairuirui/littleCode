package com.company;

/**
 * Created by dai on 2017/3/7.
 */
public class LeftRotateString {
    public static void main(String[] args) {
        // write your code here
        String string = new String("abcdefg");
        System.out.println(LeftRotateString(string,2));
    }

    public static String LeftRotateString(String str,int n) {
        /*//子串
        int length = str.length();
        if(length == 0)
            return "";
        return (str+str).substring(n, length +n);*/

        //三步反转法
        int length = str.length();
        if(length <= 1)
            return str;
        String str1 = new StringBuffer(str.substring(0,n)).reverse().toString();
        String str2 = new StringBuffer(str.substring(n,length)).reverse().toString();
        return new StringBuffer(str1+str2).reverse().toString();
    }
}
