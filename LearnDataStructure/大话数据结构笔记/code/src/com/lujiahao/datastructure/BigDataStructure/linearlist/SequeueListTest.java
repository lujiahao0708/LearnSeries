package com.lujiahao.datastructure.BigDataStructure.linearlist;

/**
 *
 * @author lujiahao
 * @date 2017/10/31
 */
public class SequeueListTest {
    public static void main(String[] args) {
        SequeueList<String> sequeueList = new SequeueList<>(9);

        for (int i = 0; i < 10; i++) {
            sequeueList.add("lujiahao" + i);
        }

        System.out.println(sequeueList.toString());
        System.out.println(sequeueList.size());
        System.out.println(sequeueList.get(1));
        System.out.println(sequeueList.lastIndexOf("lujiahao2"));
        sequeueList.set(1,"lifan");
        System.out.println(sequeueList.toString());


    }
}
