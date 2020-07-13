package com.lujiahao.concurrent.chapter10;

/**
 * 根加载器 Bootstrap类加载器
 * 最顶层加载器,没有任何父类加载器,由C++编写,主要负责虚拟机核心类库的加载,eg:java.lang包
 * @author lujiahao
 * @date 2019-11-26
 */
public class BootStrapClassLoader {
    public static void main(String[] args) {
        System.out.println("Bootstrap : " + String.class.getClassLoader());
        System.out.println("String.class的类加载器是根加载器,根加载器是获取不到的");

        System.out.println("==================================");

        System.out.println("根加载器所在路径,根据sun.boot.class.path属性获得");
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
