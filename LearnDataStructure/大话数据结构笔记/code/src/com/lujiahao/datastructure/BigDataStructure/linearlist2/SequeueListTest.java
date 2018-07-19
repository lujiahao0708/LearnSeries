package com.lujiahao.datastructure.BigDataStructure.linearlist2;

/**
 * @author lujiahao
 * @version 1.0
 * @date 2017-11-02 11:58
 */
public class SequeueListTest {
    public static void main(String[] args) throws Exception{
        SequeueList sequeueList = new SequeueList(5);
        for (int i = 0; i < 10; i++) {
            sequeueList.add(i, "lujiahao" + i);
        }
        System.out.println(sequeueList.toString());
//
//        sequeueList.insert(0,"lifan");
//        System.out.println(sequeueList.toString());

        sequeueList.delete(9);
        System.out.println(sequeueList.toString());

        System.out.println(sequeueList.get(1));
    }
}
