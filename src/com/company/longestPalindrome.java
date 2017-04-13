package com.company;

import java.util.Arrays;
/**
 * Created by dai on 2017/3/15.
 */
public class longestPalindrome {
    public static void main(String args[]){
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    // 1、Longest Palindromic Subsequence
    /*It is a typical DP problem. let's use a[i][j] represent the longest Palindromic Subsequence of S[i:j] (i,j inclusive).
So a[i][j]=
(1) a[i+1][j-1]+2 if S[i] == S[j]
(2) Max( a[i+1][j], a[i][j-1] ) if S[i]! = S[j]
    * */

    //递归(beat 97%)
    public static int longestPalindrome(String s){
        int n=s.length();
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++) a[i][i]=1;
        return helper(a,0,n-1,s);
    }
    private static int helper(int[][] a,int i,int j,String s){
        if(i>j || a[i][j]!=0) return a[i][j];
        if(s.charAt(i)==s.charAt(j)) a[i][j]=helper(a,i+1,j-1,s)+2;
        else a[i][j]=Math.max(helper(a,i,j-1,s),helper(a,i+1,j,s) );
        return a[i][j];
    }
    //另一种方法（效率不高啊）
    /*public static int longestPalindrome(String s){
        if(s==null || s.length()==0) return 0;
        int[][] len = new int[s.length()][s.length()];
        for(int j=0; j<s.length(); j++){
            len[j][j]=1;
            for(int i=j-1; i>=0; i--){
                if(s.charAt(i)==s.charAt(j)){
                    len[i][j] = len[i+1][j-1]+2;
                }else{
                    len[i][j] = Math.max(len[i+1][j], len[i][j-1]);
                }
            }
        }
        return len[0][s.length()-1];
    }*/


    // 2、Longest Palindromic Substring

    /*private int start, maxlen;
    public String longestPalindrome(String s){
        int len=s.length();
        if(len<2) return s;
        for(int i=0; i<len-1; i++){
            expendPalindrome(s, i, i);
            expendPalindrome(s, i, i+1);
        }
        return s.substring(start, start+maxlen);
    }
    private void expendPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        if(maxlen<j-i-1){
            start=++i;
            maxlen=j-i-1;
        }
    }*/

    // 3、Longest Palindrome can be build: two methods

    //字符数组(效率很高)
    /*public static int longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return 0;
        if(s.length()==1)
            return 1;
        int count=0;
        int fleg=0;
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        for(int i=1; i<s1.length; i++) {
            if(s1[i-1]==s1[i]){
                count+=2;
                i++;
                if(i==s1.length-1){
                    if(fleg==0){
                        count++;
                    }
                    break;
                }
            }else if(fleg==0){
                count++;
                fleg=1;
            }else{

            }
        }
        return count;
    }*/

    // hashset
    /*public static int longestPalindrome(String s){
        if(s==null || s.length()==0)
            return 0;
        HashSet<Character> hashSet = new HashSet<Character>();
        int count=0;
        for (int i=0; i<s.length(); i++){
            if(hashSet.contains(s.charAt(i))){
                count++;
                hashSet.remove(s.charAt(i));
            }else {
                hashSet.add(s.charAt(i));
            }
        }
        if (hashSet.isEmpty())
            return count*2;
        return count*2+1;
    }*/

}
