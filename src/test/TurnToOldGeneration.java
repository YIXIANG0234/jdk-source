package test;

/**
 * 测试长期存活的对象经历过一定的对象年龄后，将进入老年代
 * jvm参数：-verbose:gc -Xmx20M -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
 */
public class TurnToOldGeneration {
    private static final int _1MB = 1024 * 1024;
    private byte[] arr = new byte[1 * _1MB];

    public static void main(String[] args) {
        byte[] allocation1;
        byte[] allocation2;
        byte[] allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[3 * _1MB];
        allocation3 = new byte[3 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
