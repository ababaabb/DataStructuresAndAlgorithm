package test.java.com.linked;

import main.java.com.linked.MyLinked;

import java.util.LinkedList;

public class TestLinked {
    public static void main(String[] args) {
        MyLinked myLinked = new MyLinked();
        myLinked.add("5");
        myLinked.add("7");
        myLinked.add("2");
        myLinked.add("1");
        myLinked.add("6");
        myLinked.add("4");
        myLinked.add("8");
        myLinked.add("3");
        myLinked.printList();
        System.out.println("======================");
        myLinked.insertSortNode();
        myLinked.printList();

    }
}
