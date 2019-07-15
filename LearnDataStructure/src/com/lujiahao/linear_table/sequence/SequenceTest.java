package com.lujiahao.linear_table.sequence;

/**
 * @author lujiahao
 * @date 2019-07-15 18:40
 */
public class SequenceTest {
    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList<>();
        sequenceList.add("hello");
        sequenceList.add("lu");
        sequenceList.add("jia");
        sequenceList.add("hao");

        System.out.println(sequenceList.toString());
        System.out.println("长度:" + sequenceList.length());
        System.out.println("获取第一个元素:" + sequenceList.get(0));
        System.out.println("查看lu的索引:" + sequenceList.indexOf("lu"));

        sequenceList.insert("lifan", 4);
        System.out.println("新的顺序表:" + sequenceList.toString());
    }
}
