package com.lujiahao.learnjava8.chapter5;

import com.lujiahao.learnjava8.DataUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lujiahao
 * @date 2019-03-11 17:20
 */
public class ExecDemo {
    public static void main(String[] args) {
        List<Transaction> transactions = DataUtil.getTrans();

        System.out.println("(1) 找出2011年发生的所有交易，并按交易额排序(从低到高)。");
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("\n(2) 交易员都在哪些不同的城市工作过?");
        List<String> collect1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);
        // [Cambridge, Milan]

        System.out.println("\n(3) 查找所有来自于剑桥的交易员，并按姓名排序。");
        List<Trader> collect2 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println("\n(4) 返回所有交易员的姓名字符串，按字母顺序排序。");
        String reduce = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(reduce);

        System.out.println("\n(5) 有没有交易员是在米兰工作的?");
        boolean b = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(b);

        System.out.println("\n(6) 打印生活在剑桥的交易员的所有交易额。");
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("\n(7) 所有交易中，最高的交易额是多少?");
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);

        System.out.println("\n(8) 找到交易额最小的交易。");
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }
}
