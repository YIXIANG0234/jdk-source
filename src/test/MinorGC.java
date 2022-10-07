package test;

import java.util.Scanner;

/**
 * 测试young gc
 * jvm参数：-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class MinorGC {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation0, allocation1, allocation2, allocation3, allocation4;
        Scanner scanner = new Scanner(System.in);
        String line = null;
        while (!"exit".equals(line = scanner.nextLine())) {
            if ("0".equals(line)) {
                allocation0 = new byte[1 * _1MB];
            }
            if ("1".equals(line)) {
                allocation1 = new byte[2 * _1MB];
            }
            if ("2".equals(line)) {
                allocation2 = new byte[2 * _1MB];
            }
            if ("3".equals(line)) {
                allocation3 = new byte[2 * _1MB];
            }
            if ("4".equals(line)) {
                allocation4 = new byte[4 * _1MB];
            }
        }
    }
}
