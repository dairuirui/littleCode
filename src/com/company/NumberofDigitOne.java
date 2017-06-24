/*233. Number of Digit One (面试题32：从1到n整数中1出现的次数)
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13. 
*/
public class NumberofDigitOne {
    //方法一：累加每个整数中1出现的次数（会超时，不能用）
    /*
    Status: Time Limit Exceeded
    Last executed input: 824883294
    */
    public int countDigitOne1(int n) {
        int count=0;
        for(int i=1; i<=n; i++){
            int temp=i;
            while(temp>0){
                if((temp%10) == 1) 
                    count++;
                temp = temp/10;
            }
        }
        
        return count;
    }


    //方法二：从数字规律提高时间效率的解法
    //time com:O(logn), space com:O(1)
    //Runtime: 0 ms, beats 19.26 %
    public int countDigitOne2(int n) {
        /*可以用统计学方法来计算，假设从个位开始，每次假设某一位的数字是1，然后统计剩下位数的数字中满足条件的可能情况数。其时间复杂度为O(log n).考虑把某一个位的数字设成1后，分析他位置有多少种选择。然后把每个数字位取1而有的选择都加起来就可以了。将输入的整数n分割成3部分：当前位之前部分front, 当前位curDigit和当前位之后部分back.
然后来分析其他位置有多少种选择：
(1) 如果将n的个位数置为1，xxx1
该位的数字置1之前为0，
card({000, 001...134})，满足条件的数共有135个

(2) 如果将n的十位数置为1，xx1x
该位的数字置1之前5>1，
card({000, 001...139})，共140个

(3) 如果将n的百位数置为1，x1xx
该位的数字置1之前3>1，
2*card({00, 01...99})，共200个

(4) 如果将n的千位数置为1，1xxx
该位的数字置1之前=1，
card({000,001...350})，共351个

于是所求的值count=135+140+200+351=826个1
        */
        if(n<=0) return 0;
        
        long cur, front, back, mod=1;
        long count=0;
        while(mod<=n){
            back=n%mod; //当前之后的部分
            front=n/(mod*10); //当前数之前的部分
            cur=(n/mod)%10; //当前置1的位置原来的数
            
            if(cur==0)
                count=count+front*mod;
            else if(cur==1)
                count=count+(front*mod+back+1);
            else if(cur>1)
                count=count+(front+1)*mod;
            
            mod*=10;
        }
        
        return (int)count;
    }
}