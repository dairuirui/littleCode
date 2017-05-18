package com.company;

/**
 * Created by dai on 2017/5/16.
 */
public class Print1ToMaxOfNDigits {
    public static void main(String args[]){
        print1ToMaxOfNDigits2(2);
    }

    //��ӡ��1������nλ��

    //����һ�����ַ�����ģ�����ּӷ����Ӷ����Դ����������
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
    public static boolean addNumber(StringBuffer number){//ͨ�����λ�Ƿ��н�λ�ж��Ƿ����
        int takeOver = 0;//��λ
        boolean isOverflow = false;
        for(int i = number.length()-1; i >= 0; i--){//�����һλ��ʼ��1
            int iSum = number.charAt(i) - '0' + takeOver;
            if(i == number.length()-1)//������һλ��ֱ�Ӽ�1
                iSum++;

            if(iSum >= 10){//�н�λ
                if(i == 0)//�ж����
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
    public static void printNumber(StringBuffer number){//��λ��0����ӡ
        boolean isBeginning0 = true;
        for(int i=0; i<number.length(); ++i){
            if(isBeginning0 && number.charAt(i) != '0')
                isBeginning0 = false;
            if(!isBeginning0)
                System.out.print(number.charAt(i));
        }
        System.out.println();
    }

    //�����������������еķ�����ʾ���������������ǰ�油0�Ļ����ͻᷢ��nλ����ʮ��������ʵ����n����0��9��ȫ���С�
    //Ҳ����˵�����ǰ����ֵ�ÿһλ����0��9����һ�飬�͵õ������е�ʮ����������Ȼ��ӡ��ʱ������Ӧ�ý�ǰ���0��λȥ����
    //�ݹ�
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
