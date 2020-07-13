package com.lujiahao.concurrent.chapter10;

/**
 * 系统类加载器
 * 1.负责加载classpath下的类库资源
 * 2.系统类加载器的父加载器是扩展类加载器,同时也是自定义类加载器的默认父加载器
 * 3.可以通过java.class.path获取
 * @author lujiahao
 * @date 2019-11-26
 */
public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
