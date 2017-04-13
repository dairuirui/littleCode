package com.company;

import java.util.HashMap;

/**
 * Created by dai on 2017/3/13.
 */
public class StringContain {
    public static void main(String[] args) {
        // write your code here
        String string1 = new String("ABCD");
        String string2 = new String("BCE");
        if(StringContain(string1, string2) == true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    //Hashtable
    public static boolean StringContain(String a,String b){
        HashMap hashtable = new HashMap();
        for(int i = 0; i < a.length(); i++){
            hashtable.put(i, a.charAt(i));
        }
        for(int j = 0; j < b.length(); j++){
            if(!hashtable.containsValue(b.charAt(j)))
                return false;
        }
        return true;
    }

    /*//λ����
    public static boolean StringContain(String a,String b)
    {
        int hash = 0;
        for(int i = 0; i < a.length(); i++){
            hash |= (1 << (a.charAt(i) - 'A'));//1��int�ͣ�32λ������(a.charAt(i) - 'A')λ������һ��������ַ�
        }
        for(int i = 0; i < b.length(); i++){
            if((hash & (1 << (b.charAt(i) - 'A'))) == 0)
                return false;
        }
        return true;

    }*/
}
