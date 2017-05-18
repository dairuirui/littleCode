package com.company;

/**
 * Created by dai on 2017/5/16.
 */
public class Print1ToMaxOfNDigits {
    public static void main(String args[]){
        print1ToMaxOfNDigits2(2);
    }

    //打印从1到最大的n位数

    //方法一：在字符串上模拟数字加法，从而可以处理大数问题
    public static void print1ToMaxOfNDigits1(int n){
        if(n<=0)
            return;

        StringBuffer number = new StringBuffer();
        for(int i=0; i<n; i++)
            number.append(0);

        while(!addNumber(number)){
            printNumber(number);
        }
    }
    public static boolean addNumber(StringBuffer number){//通过最高位是否有进位判断是否溢出
        int takeOver = 0;//进位
        boolean isOverflow = false;
        for(int i = number.length()-1; i >= 0; i--){//从最后一位开始加1
            int iSum = number.charAt(i) - '0' + takeOver;
            if(i == number.length()-1)//如果最后一位，直接加1
                iSum++;

            if(iSum >= 10){//有进位
                if(i == 0)//判断溢出
                    isOverflow = true;
                else{
                    iSum -= 10;
                    takeOver = 1;
                    number.setCharAt(i, (char)('0'+iSum));
                }
            }else{
                number.setCharAt(i, (char)('0'+iSum));
                break;
            }
        }
        return isOverflow;
    }
    public static void printNumber(StringBuffer number){//高位的0不打印
        boolean isBeginning0 = true;
        for(int i=0; i<number.length(); ++i){
            if(isBeginning0 && number.charAt(i) != '0')
                isBeginning0 = false;
            if(!isBeginning0)
                System.out.print(number.charAt(i));
        }
        System.out.println();
    }

    //方法二：用数字排列的方法表示：如果我们在数字前面补0的话，就会发现n位所有十进制数其实就是n个从0到9的全排列。
    //也就是说，我们把数字的每一位都从0到9排列一遍，就得到了所有的十进制数。当然打印的时候，我们应该将前面的0补位去掉。
    //递归
    public static void print1ToMaxOfNDigits2(int n){
        if(n<=0)
            return;

        StringBuffer number = new StringBuffer();
        for(int i=0; i<n; i++)
            number.append(0);

        for(int i=0; i<10; i++){
            number.setCharAt(0, (char) ('0' + i));
            arrange(number, n, 1);
        }
    }
    public static void arrange(StringBuffer number, int n, int index){
        if(index == n){
            printNumber(number);
            return;
        }

        for(int i=0; i<10; i++){
            number.setCharAt(index, (char)('0'+i));
            arrange(number, n, index+1);
        }
    }
}
