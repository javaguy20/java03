package singlylinklist;

import java.util.ArrayList;
import java.util.List;


public class InvalidIndexException extends Exception {
    public InvalidIndexException(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        String i1=new String("qw");
        String i2=new String("ee");
        String i3=new String("rt");
        String i4=new String("yh");
        list.add(i1);
        list.add(i2);
        list.add(i3);
        list.add(i4);
        System.out.println(list);
       String d=list.remove(2);
        System.out.println(d);
        System.out.println(list);
    }
}
/*
* [29, 20, 11, 12]
11
[29, 20, 12]
*
* */