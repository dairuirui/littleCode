//数组中的逆序对
/*
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5*/
//运行时间：742ms，占用内存：46904k
public class Solution {
    public int InversePairs(int [] array) {
        if(array==null || array.length<=0) 
            return -1;
        
        int[] copy=new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        
        return inversePairsCore(array, copy, 0, array.length-1);
    }
    
    //分治思想，归并排序，递归
    /*先把数组分隔成子数组， 先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。在统计逆序对的过程中，还需要对数组进行排序。*/
    public int inversePairsCore(int[] array, int[] copy, int start, int end){
        if(start == end) return 0;
        
        int length=(end-start)/2;
        int left=inversePairsCore(copy, array, start, start+length);
        int right=inversePairsCore(copy, array, start+length+1, end);
        int count=0;//逆序数
        int i=start+length;//前半段最后一个数字的下标
        int j=end;//后半段最后一个数字的下标
        int indexCopy=end;
        
        while(i>=start && j>=start+length+1){
            if(array[i]>array[j]){
                copy[indexCopy]=array[i];
                i--;
                indexCopy--;
                count+=j-start-length;//对应的逆序数
                if(count>1000000007){
                    count=count%1000000007;
                }
            }else{
                copy[indexCopy]=array[j];
                indexCopy--;
                j--;
            }
        }
        
        for(; i>=start; ){
            copy[indexCopy]=array[i];
            i--;
            indexCopy--;
        }
        
        for(; j>=start+length+1; ){
            copy[indexCopy]=array[j];
            j--;
            indexCopy--;
        }
        
        return (count+left+right)%1000000007;
    }
}
