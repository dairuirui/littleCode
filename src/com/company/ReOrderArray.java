package com.company;
import java.util.LinkedList;

/**
 * Created by dai on 2017/5/20.
 */
public class ReOrderArray {
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
    public static void main(String[] args){
        int[] array = new int[]{1,2,5,8,3,1};
        reOrderArray2(array);
        for(int i=0; i<array.length; i++)
            System.out.print(array[i]);
    }

    //idea:声明两个指针，前后扫描数组，然后交换前面的偶数与后面的奇数
    //time com:O(n),,space com:O(1)
    public static void reOrderArray1(int[] array){
        int left=0, right=array.length-1;
        while(left < right){
            while(left<right && !isEven(array[left]))
                left++;
            while(left<right && isEven(array[right]))
                right--;
            if(left<right){
                int tamp = array[left];
                array[left] = array[right];
                array[right] = tamp;
            }
        }
    }
    public static boolean isEven(int n){
        return (n&1) == 0;
    }


    //进阶：保证奇数和奇数，偶数和偶数之间的相对位置不变。
    /*
    *先扫描一遍数组，做三件事，
    * 1、奇数往前挪，
    * 2、统计偶数个数，
    * 3、保存偶数到队列。
    * 扫描结束后，奇数都被挪到了前边，紧凑的挨在一块，后边留出了一些空余的位置，位置的个数就是偶数的个数。将保存在队列里边的偶数按照进队列的顺序塞到后边的空余位置即可。
    * */
    //time complexty:O(n),apace com:O(n)
    //运行时间：29ms 占用内存：629k
    public static void reOrderArray2(int [] array) {
        LinkedList<Integer> queue = new LinkedList<>();
        int evenNum = 0;
        for(int i=0; i<array.length; i++){
            if(isEven(array[i])){
                evenNum++;
                queue.add(array[i]);
            }else{
                array[i-evenNum] = array[i];
            }
        }

        for(int j=array.length-evenNum; j<array.length; j++){
            array[j] = queue.pop();
        }
    }
}
