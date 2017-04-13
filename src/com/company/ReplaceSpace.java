package com.company;

/**
 * Created by dai on 2017/4/6.
 */
public class ReplaceSpace {

    //时间复杂度O(n),空间复杂度O(1)
    //运行时间24ms，占用内存503k
    public String replaceSpae(StringBuffer str){
        if(str == null)
            return null;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                str.replace(i, i+1, "%20");
        }
        return str.toString();
    }

    //时间、空间复杂度O(n)
    //运行时间25ms，占用内存629k
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
