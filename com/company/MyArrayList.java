package com.company;
import java.util.Arrays;
public class MyArrayList {
    private int[] arr;
    private int size;

    MyArrayList(){
        this.arr = new int[5];
        this.size = 0;
    }
    public void addElement(int element){
        if(size == arr.length) {
            increaseBuffer();
        }
        arr[size++] = element;
    }
    private void increaseBuffer(){
        int[] newArr = new int[arr.length * 2];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    public int getElement(int index){
        checkIndex(index);
        return arr[index];
    }

    public int getSize(){
        return size;
    }

    public void clear(){
        this.arr = new int[5];
        this.size = 0;
    }

    private void checkIndex(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }
    public void delete(int index){
        checkIndex(index);
        for(int i=index+1; i<size; i++){
            arr[i-1]= arr[i];
        }
        size--;
    }
    public String toArray() {
        return Arrays.toString(arr);
    }
}
