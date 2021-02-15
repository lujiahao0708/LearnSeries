package com.lujiahao.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _20 {
    public static void main(String[] args) {
        String str = "(]";
        System.out.println(test2(str));
    }

    public static boolean test(String s) {
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        for (String r : arr) {
            if ("(".equals(r) || "[".equals(r) || "{".equals(r)) {
                stack.push(r);
            } else {
                if (!stack.isEmpty() && ")".equals(r) && stack.peek().equals("(")) {
                    stack.pop();
                } else if (!stack.isEmpty() && "]".equals(r) && stack.peek().equals("[")) {
                    stack.pop();
                } else if (!stack.isEmpty() && "}".equals(r) && stack.peek().equals("{")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean test2(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (')' == c && '(' == stack.peek() || ']' == c && '[' == stack.peek() || '}' == c && '{' == stack.peek()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
