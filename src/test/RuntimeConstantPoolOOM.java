package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示方法区内存溢出，该实验需要在jdk1.6之前版本才能复现，jdk1.7之后已移除永久代，使用元数据区替代
 * jvm参数：-XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add((RuntimeConstantPoolOOM.class.getName() + i).intern());
            i++;
        }
    }
}
