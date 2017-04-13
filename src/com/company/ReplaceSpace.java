package com.company;

/**
 * Created by dai on 2017/4/6.
 */
public class ReplaceSpace {

    //ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
    //����ʱ��24ms��ռ���ڴ�503k
    public String replaceSpae(StringBuffer str){
        if(str == null)
            return null;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                str.replace(i, i+1, "%20");
        }
        return str.toString();
    }

    //ʱ�䡢�ռ临�Ӷ�O(n)
    //����ʱ��25ms��ռ���ڴ�629k
//    public String replaceSpace(StringBuffer str) {
//        if(str == null)
//            return null;
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0; i < str.length(); i++){
//            if (str.charAt(i) == ' '){
//                stringBuilder.append("%20");
//            }else{
//                stringBuilder.append(str.charAt(i));
//            }
//        }
//        return stringBuilder.toString();
//    }
}
