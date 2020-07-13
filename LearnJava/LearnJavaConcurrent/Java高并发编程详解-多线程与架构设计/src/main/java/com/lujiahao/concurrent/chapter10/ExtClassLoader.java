package com.lujiahao.concurrent.chapter10;

/**
 * 扩展类加载器
 * 1.它的父加载器是根加载器,主要用于加载JAVA_HOME下的jre/lib/ext子目录中的类库
 * 2.由Java语言实现,是java.lang.URLClassLoader的子类,它的完成类名:sun.misc.Launcher$ExtClassLoader
 * 3.可以通过系统属性java.ext.dirs
 * 4.也可以将自己的类打包放到所在路径中,即可加载到JVM
 * @author lujiahao
 * @date 2019-11-26
 */
public class ExtClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));
    }
}
