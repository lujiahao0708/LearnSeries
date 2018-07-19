package com.lujiahao.datastructure.BigDataStructure.linearlist;

/**
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-01 15:04
 */
public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>("lujiahao");

        for (int i = 0; i < 4; i++) {
            linkList.add("lujiahao" + i);
        }
//        System.out.println(linkList);
//        System.out.println("size:" + linkList.size());
//
//        linkList.addAtHead("lifan");
//        System.out.println(linkList);
//
//        linkList.add("fanfan");
//        System.out.println(linkList);
//
//        linkList.insert(1, "lflf");
        System.out.println(linkList);

        String s = linkList.get(0);
        System.out.println(s);
    }
}
