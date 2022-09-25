package test;

public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true){
            // 借助cglib等字节码工具动态生成大量class，使其填满方法区，造成内存溢出
        }
    }
}
