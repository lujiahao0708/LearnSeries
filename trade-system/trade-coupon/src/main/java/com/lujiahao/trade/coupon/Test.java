package com.lujiahao.trade.coupon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lujiahao
 * @date 2018-06-11 上午10:51
 */
public class Test {
    public static void main(String[] args) {
        List<Amount> list = new ArrayList<Amount>();
        //创建3个对象，金额分别是7000、9000、8000，6000并将他们依次放入List中
        Amount a1 = new Amount();
        a1.setAmount(7000d);
        Amount a2 = new Amount();
        a2.setAmount(9000d);
        Amount a3 = new Amount();
        a3.setAmount(8000d);
        Amount a4 = new Amount();
        a4.setAmount(6000d);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);

        // 降序
        Collections.sort(list, new Comparator<Amount>() {
            /*
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(Amount o1, Amount o2) {
                //按照金额大小进行降序排列
                if (o1.getAmount() < o2.getAmount()) {
                    return 1;
                }
                if (o1.getAmount() == o2.getAmount()) {
                    return 0;
                }
                return -1;
            }
        });
        System.out.println("降序");
        System.out.println(list);

        // 升序
        Collections.sort(list, new Comparator<Amount>() {
            /*
             * int compare(Student o1, Student o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(Amount o1, Amount o2) {
                //按照金额大小进行降序排列
                if (o1.getAmount() > o2.getAmount()) {
                    return 1;
                }
                if (o1.getAmount() == o2.getAmount()) {
                    return 0;
                }
                return -1;
            }
        });

        System.out.println("升序");
        System.out.println(list);
    }
}
