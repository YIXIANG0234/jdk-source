package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用循环，逐渐创建对象，使用jconsole观察堆内存曲线变化清空
 * jvm参数：-Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class JConsole {
    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new OOMObject());
            Thread.sleep(500);
        }
    }

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }
}
