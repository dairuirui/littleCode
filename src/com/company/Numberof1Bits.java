package com.company;

/**
 * Created by dai on 2017/4/30.
 */
public class Numberof1Bits {
    public static void main(String args[]){
        System.out.println(hammingWeight1(9));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight1(int n) {//����
        //������Ч�ʱ���λ����ͺܶ࣬ʵ�ʱ����Ӧ������ʹ����λ���������˳���
        //�����������жϸ���λ�ǲ���1����Ҫѭ��32��
        int count = 0;
        int flag = 1;
        while(flag!=0){

            if((n & flag) !=0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {//����
        //��һ��������ȥ1���ں�ԭ�����������㣬��Ѹ��������ұߵ�1���0. ��ôһ�������Ķ��������ж��ٸ�1���Ϳ��Խ��м��������Ĳ�����
        //�������м���1��ֻ��Ҫѭ������
        //Runtime: 1 ms�� beats 90.35 %
        int count = 0;
        while(n!=0){
            n = (n-1) & n;
            count++;
        }
        return count;
    }
}
