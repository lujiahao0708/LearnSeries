package com.lujiahao.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Data2> listOfData2 = new ArrayList<Data2>();

        listOfData2.add(new Data2("a"  , "Type1"));
        listOfData2.add(new Data2("b"  , "Type5"));
        listOfData2.add(new Data2("c"  , "Type4"));


        List<Data1> listOfData1 = new ArrayList<Data1>();

        listOfData1.add(new Data1("a"    ,3000000));
        listOfData1.add(new Data1("aa"    ,6225000));
        listOfData1.add(new Data1("bb"  ,2005000));
        listOfData1.add(new Data1("c"    ,3000000));
        listOfData1.add(new Data1("d"    ,3000000));

        List<OutputData> result = listOfData1.stream()
                .flatMap(x -> listOfData2.stream()
                        .filter(y -> x.getName().equals(y.getName()))
                        .map(y -> new OutputData(x.getName(), y.getType(), x.getAmount())))
                .collect(Collectors.toList());
        System.out.println(result);
    }
}


 class Data1 {
    private String name;
    private int amount;

     public Data1(String name, int amount) {
         this.name = name;
         this.amount = amount;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getAmount() {
         return amount;
     }

     public void setAmount(int amount) {
         this.amount = amount;
     }
 }

 class Data2 {
    private String name;
    private String type;

     public Data2(String name, String type) {
         this.name = name;
         this.type = type;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }
 }

 class OutputData {
    private String name;
    private String type;
    private int amount;

     public OutputData(String name, String type, int amount) {
         this.name = name;
         this.type = type;
         this.amount = amount;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public int getAmount() {
         return amount;
     }

     public void setAmount(int amount) {
         this.amount = amount;
     }

     @Override
     public String toString() {
         return "OutputData{" +
                 "name='" + name + '\'' +
                 ", type='" + type + '\'' +
                 ", amount=" + amount +
                 '}';
     }
 }

//
//    @Test
//    public void intersectByKeyTest(){
//
//
//        /*difference by key*/
//        List<Data1> data1IntersectResult = listOfData1.stream().filter(data1 -> listOfData2.stream().map(Data2::getId).collect(Collectors.toList()).contains(data1.getId())).collect(Collectors.toList());
//        System.out.println(data1IntersectResult);
//    }
