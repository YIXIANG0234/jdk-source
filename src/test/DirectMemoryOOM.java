package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 演示本机直接内存溢出，使用MaxDirectMemorySize设置本机直接内存大小
 * jvm参数：-Xmx20m -XX:MaxDirectMemorySize=10m
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
