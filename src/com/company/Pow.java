package com.company;

import java.util.Map;

/**
 * Created by dai on 2017/5/9.
 */
public class Pow {
    public static void main(String args[]){
        System.out.println(myPow2(2, Integer.MIN_VALUE));
    }

    //Ԥ���ж��������
    //Runtime: 28 ms��beats 13.32 %
    public static double myPow1(double x, int n) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        if(x == -1){
            if(n%2 ==0) return 1;
            else return -1;
        }
        if(n == Integer.MIN_VALUE) return 0;
        if(n < 0) return 1/myPow1(x, Math.abs(n));
        if(n == 0) return 1;
        double result = x;
        for(int i=1; i<n; i++){
            result *= x;
            //xΪ0.000001�����ⳬʱ
            if(result == 0)
                return 0;
        }
        return result;
    }

    //����ȫ�ֱ�������־�Ƿ����������ˣ��޸�ȫ�ֱ�����������0.(��ʵ����һ�ַ�����idea��һ���ģ����Լ��˼���ȫ�ֱ���)
    //Runtime: 41 ms, beats 1.21 %
    static boolean invalidInput = false;
    public static double myPow2(double x, int n) {
        //xΪ1��-1��������ⳬʱ��ע�����n == Integer.MIN_VALUEǰ�棬��Ϊ1���κδ���Ϊ1��
        if(x == 1) return 1;
        if(x == -1){
            if(n%2 ==0) return 1;
            else return -1;
        }
        //���벻�Ϸ�������ȫ�ֱ�����������0
        if((x == 0 && n <= 0) || n == Integer.MIN_VALUE){
            invalidInput = true;
            return 0;
        }
        if(x == 0) return 0;
        if(n == 0) return 1;
        double result = x;
        for(int i=1; i<Math.abs(n); i++){//ָ��n�п���Ϊ����
            result *= x;
            //xΪ0.000001�����ⳬʱ
            if(result == 0)
                return 0;
        }
        if(n < 0)
            result = 1/result;
        return result;
    }

    //ʹ�õݹ飬����ƽ������ƽ���Ļ�������4�η���Ȼ����8�η�������������
    //Runtime: 20 ms��beats 79.36 %
    public double myPow(double x, int n) {
        //xΪ1��-1��������ⳬʱ��ע�����n == Integer.MIN_VALUEǰ�棬��Ϊ1���κδ���Ϊ1��
        if(x == 1) return 1;
        if(x == -1){
            if(n%2 ==0) return 1;
            else return -1;
        }
        //���벻�Ϸ�������ȫ�ֱ�����������0
        if((x == 0 && n <= 0) || n == Integer.MIN_VALUE){
            invalidInput = true;
            return 0;
        }
        if(x == 0) return 0;
        if(n == 0) return 1;
        int unsignedN = Math.abs(n);
        double result = powWithUnsignedN(x,unsignedN);
        if(n < 0)
            result = 1/result;
        return result;
    }
    public static double powWithUnsignedN(double x, int n){
        if(n == 1) return x;
        if(n == 0) return 1;
        double result = powWithUnsignedN(x,n>>1);//�����ƴ����2.Ч�ʸ���
        result *= result;
        if((n&1) == 1)//��������������������%�����Ч��
            result *= x;
        return result;
    }

}
