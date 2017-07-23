//丑数：

/*263. Ugly Number 
 Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. 
*/
public class Solution{
    public boolean isUgly(int num) {
        if(num <= 0) return false;
        
        while(num%2 == 0) num = num/2;
        while(num%3 == 0) num = num/3;
        while(num%5 == 0) num = num/5;
        if(num == 1) return true;
        else return false;
    }
}



/*264. Ugly Number II 
 Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. 
*/
//该题考查动态规划。一个因子是2，3，5中的一个，另一个因子在 uglys 数组中，该因子下标存储在 index 数组中：
public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        
        int index[] = new int[3];
        int uglys[] = new int[n];
        uglys[0] = 1;
        for(int i=1; i<n; i++){
            int a=uglys[index[0]]*2;
            int b=uglys[index[1]]*3;
            int c=uglys[index[2]]*5;
            int min=Math.min(a, Math.min(b,c));
            if(min==a) index[0]++;
            if(min==b) index[1]++;
            if(min==c) index[2]++;
            
            uglys[i]=min;
        }
        return uglys[n-1];
    }
}



/*313. Super Ugly Number 
 Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
(4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer. 
*/
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n<=0 || primes.length==0) return 0;
        
        int[] index=new int[primes.length];
        int[] uglys=new int[n];
        uglys[0]=1;
        for(int i=1; i<n; i++){
            uglys[i]=Integer.MAX_VALUE;
            //求最小的uglys[i]
            for(int j=0; j<primes.length; j++){
                uglys[i]=Math.min(uglys[i], uglys[index[j]]*primes[j]);
            }
            //更新uglys[i]对应的index，可能有多个
            for(int j=0; j<primes.length; j++){
                if(uglys[i] == uglys[index[j]]*primes[j])
                    index[j]++;
            }
        }
        return uglys[n-1];
    }
}