package com.lujiahao.datastructure.BigDataStructure.queue.linkqueue.impl;

import com.lujiahao.datastructure.BigDataStructure.queue.linkqueue.LinkQueue;

/**
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-16 17:18
 */
public class Test {

    public static void main(String[] args) throws Exception {

        String str1 = "ABCDCBA";
        String str2 = "ABCDECAB";

        if (Test.isHuiWen(str1)) {
            System.out.println(str1 + ":是回文！");
        } else {
            System.out.println(str1 + ":不是回文！");
        }

        if (Test.isHuiWen(str2)) {
            System.out.println(str2 + ":是回文！");
        } else {
            System.out.println(str2 + ":不是回文！");
        }
    }

    /**
     * 判断字符串是否回文
     */
    public static boolean isHuiWen(String str) throws Exception {
        int n = str.length();
        LinkStack stack = new LinkStack();
        LinkQueue queue = new LinkQueue();
        for (int i = 0; i < n; i++) {
            String node = str.subSequence(i, i + 1).toString();
            // 把字符串每个字符压进堆栈
            stack.push(node);
            // 把字符串每个字符压入队列
            queue.append(node);
        }
        while (!queue.isEmpty() && !stack.isEmpty()) {
            //出队列，出栈，同时判断是否相同
            // 出队列相当于顺序读   出栈相当于倒序读  如果一样就是回文
            if (!queue.delete().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

}