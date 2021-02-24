package ru.geekbrains.interview_preparation.hw2;

import ru.geekbrains.interview_preparation.hw2.array.ArrayImpl;
import ru.geekbrains.interview_preparation.hw2.linkedList.LinkedList;
import ru.geekbrains.interview_preparation.hw2.linkedList.LinkedListImpl;

public class Main2 {

    public static void main(String[] args) {
        testLinkedListImpl();
        testArrayListImpl();
    }

    private static void testArrayListImpl() {
        ArrayImpl<Integer> myArray = new ArrayImpl<>();

        for (int i = 0; i < 20; i++) {
            myArray.add(2 * i);
        }

        System.out.println(myArray.toString());
    }

    private static void testLinkedListImpl() {
        
        LinkedList<Integer> list = new LinkedListImpl<>();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

        list.display();
    }

}
