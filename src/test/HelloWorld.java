package test;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("good");
        list.add("morning");
        list.add("hello");
        list.add("world");
        for (String line : list) {
            System.out.println(line);
        }
    }
}
