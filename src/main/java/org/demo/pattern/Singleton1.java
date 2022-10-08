package org.demo.pattern;

import java.io.Serializable;

// 1. 饿汉式
public class Singleton1 implements Serializable {
    private Singleton1() {
        if (INSTANCE != null) {
            throw new RuntimeException("单例对象不能重复创建");
        }
        System.out.println("private Singleton1()");
    }

    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    public static void otherMethod() {
        System.out.println("otherMethod()");
    }

    /**
     * 提供readResolve()方法
     * 当JVM反序列化恢复一个新对象时，系统会自动调用readResolve()方法返回指定好的对象
     * 从而保证系统通过反序列化机制不会产生多的Java对象
     *
     * @return 单例对象
     */
    public Object readResolve() {
        return INSTANCE;
    }
}
