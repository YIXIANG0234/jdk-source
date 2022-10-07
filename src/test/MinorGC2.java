package test;

import java.util.Scanner;

/**
 * 测试young gc
 * jvm参数：-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 设置大于该参数的大对象，直接在老年代分配内存：-XX:PretenureSizeThreshold=2097152，该参数只对Serial和ParNew有效
 */
public class MinorGC2 {
    private static final int _1MB = 1024 * 1024;
    private byte[] arr = new byte[1 * _1MB];

    public static void main(String[] args) {
        byte[] allocation0;
        byte[] allocation1;
        byte[] allocation2;
        byte[] allocation3;
        allocation0 = new byte[2 * _1MB];
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        /*
        此时会发生MinorGC,将eden区和from区存活的对象复制到to区，并清空eden区和from区内存，最后交换from区和to区
        但是这里eden区存活的对象大于to区的内存空间，所以启用分配担保机制，将eden区存活对象复制到老年代，然后再在eden区给
        allocation3分配内存，可条件allocation3的内存大小，观察eden区的变化
         */
        allocation3 = new byte[3 * _1MB];
    }
}
