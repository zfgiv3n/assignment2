package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.addElement(4);
        myArrayList.addElement(6);
        myArrayList.addElement(8);
        myArrayList.addElement(11);
        myArrayList.addElement(15);
        myArrayList.addElement(scanner.nextInt());
        System.out.println(myArrayList.getElement(0));
        System.out.println(myArrayList.getSize());
        //System.out.println(myArrayList.getElement(15));
        //myArrayList.clear();
        //System.out.println(myArrayList.getSize());
        System.out.println(myArrayList.getElement(3));
        myArrayList.delete(3);
        System.out.println(myArrayList.getElement(3));
        System.out.println(myArrayList.toArray());
    }
}