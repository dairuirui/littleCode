package com.company;
import java.util.LinkedList;

/**
 * Created by dai on 2017/5/20.
 */
public class ReOrderArray {
//����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿��
    public static void main(String[] args){
        int[] array = new int[]{1,2,5,8,3,1};
        reOrderArray2(array);
        for(int i=0; i<array.length; i++)
            System.out.print(array[i]);
    }

    //idea:��������ָ�룬ǰ��ɨ�����飬Ȼ�󽻻�ǰ���ż������������
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


    //���ף���֤������������ż����ż��֮������λ�ò��䡣
    /*
    *��ɨ��һ�����飬�������£�
    * 1��������ǰŲ��
    * 2��ͳ��ż��������
    * 3������ż�������С�
    * ɨ���������������Ų����ǰ�ߣ����յİ���һ�飬���������һЩ�����λ�ã�λ�õĸ�������ż���ĸ������������ڶ�����ߵ�ż�����ս����е�˳��������ߵĿ���λ�ü��ɡ�
    * */
    //time complexty:O(n),apace com:O(n)
    //����ʱ�䣺29ms ռ���ڴ棺629k
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
