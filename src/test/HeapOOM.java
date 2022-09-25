package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示堆内存溢出
 * jvm参数：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(new OOMObject());
                count++;
            }
        } catch (Throwable e) {
            System.out.println("object count：" + count);
            e.printStackTrace();
        }
    }
}
