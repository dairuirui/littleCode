/*第一个只出现一次的字符
387. First Unique Character in a String 
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters. 
*/

//方法一：Runtime: 39 ms， beats 40.78 %
public class Solution {
    public int firstUniqChar(String s) {
        for(int i=0; i<s.length(); i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
                return i;
        }
        return -1;
    }
}

//方法二：Runtime: 36 ms， beats 43.58 %
/*
 It takes O(n) and goes through the string twice:
 1. Get the frequency of each character.
 2. Get the first character that has a frequency of one.
 Actually the code below passes all the cases. However, according to @xietao0221, 
 we could change the size of the frequency array to 256 to store other kinds of characters. 
*/
 public class Solution {
    public int firstUniqChar(String s) {
        int[] freq=new int[26];
        for(int i=0; i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(freq[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1;
    }
}
