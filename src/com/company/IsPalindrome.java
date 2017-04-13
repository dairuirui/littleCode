package com.company;

import java.util.Stack;

/**
 * Created by dai on 2017/3/13.
 */
public class IsPalindrome {
    public static void main(String[] args) {
        // write your code here
        String string1 = new String("abcd");
        if(isPisPalindrome(string1) == true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    //Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    //Palindrome String
   /* public static boolean isPisPalindrome(String s){
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }*/

    //Valid Palindrome
    public static boolean isPisPalindrome(String s){
        String lowStr = s.toLowerCase();
        for(int i=0,j=s.length()-1; i<=j; ){
            if(lowStr.charAt(i)<'0' || (lowStr.charAt(i)>'9' && lowStr.charAt(i)<'a') || lowStr.charAt(i)>'z' )
                i++;
            else if(lowStr.charAt(j)<'0' || (lowStr.charAt(j)>'9' && lowStr.charAt(j)<'a') || lowStr.charAt(j)>'z' )
                j--;
            else if(lowStr.charAt(i) != lowStr.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    //Palindrome String£º by stack
   /* public static boolean isPisPalindrome(String s){
        Stack stack = new Stack();
        for(int i=0; i<s.length(); i++){
            stack.push(s.substring(i,i+1));
        }
        for(int i=0; i<s.length(); i++){
            if(s.substring(i, i+1).equals(stack.pop().toString()) )
                return false;
        }
        return true;
    }*/

    //Palindrome Number
    public static boolean isPalindrome(int x) {
        int i =0;
        int a = x;
        while(a > 0){
            i= i*10+a%10;
            a=a/10;
        }
        return i==x;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
