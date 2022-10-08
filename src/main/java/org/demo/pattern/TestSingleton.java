package org.demo.pattern;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {
    public static void main(String[] args) throws Exception {
        // 当需要测试其他单例模式时，修改不同的实例 Singleton1, Singleton2, Singleton3, Singleton4, Singleton5
        Singleton1.otherMethod();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(Singleton1.getInstance());
        System.out.println(Singleton1.getInstance());

        // 反射破坏单例
//        reflection(Singleton3.class);

        // 反序列化破坏单例
//        serializable(Singleton3.getInstance());

        // Unsafe 破坏单例
//        unsafe(Singleton3.class);
    }

    private static void unsafe(Class<?> clazz) throws InstantiationException {
        Object o = UnsafeUtils.getUnsafe().allocateInstance(clazz);
        System.out.println("Unsafe 创建实例:" + o);
    }

    private static void serializable(Object instance) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(instance);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        System.out.println("反序列化创建实例:" + ois.readObject());
    }

    private static void reflection(Class<?> clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        System.out.println("反射创建实例:" + constructor.newInstance());
    }
}
