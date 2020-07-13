package com.lujiahao.concurrent.chapter10;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自定义类加载器
 * 必须是ClassLoader的直接或间接子类
 * @author lujiahao
 * @date 2019-11-26
 */
public class MyClassLoader extends ClassLoader{
    // 默认class存放路径
    private final static Path DEFAULT_CLASS_DIR = Paths.get("classDir");

    private final Path classDir;

    // 使用默认class路径
    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    // 允许传入指定class路径
    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    // 指定class路径同时,指定父类加载器
    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    // 重写父类的方法
//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//
//
//    }
}
