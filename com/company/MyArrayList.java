package com.company;

public class MyArrayList<T> implements MyList {
    private T[] arr; // array with generic type that can be store any types of value
    private int size; // size of array

    public MyArrayList() {
        this.arr = (T[]) new java.lang.Object[5]; // creating array with allocated space 5
        this.size = 0; // equate to 0 because of empty of array
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    private void increaseLength() {
        T[] newArr = (T[]) new java.lang.Object[arr.length*2]; // doubling allocated space of array  to contain more values
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i]; // save exist values
        }
        arr = newArr;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    public boolean contains(java.lang.Object o) {
        boolean bool = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) { // checking is given element equal to elements of array
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public void add(java.lang.Object item) {
        if(size == arr.length){ // checking is array have enough space to add new value
            increaseLength(); // increase space of array if not
        }
        arr[size++] = (T) item;
    }

    @Override
    public void add(java.lang.Object item, int index) {
        if (size == arr.length) { // checking is array have enough space to add new value
            increaseLength(); // increase space of array if not
        }
        T[] newArr = (T[]) new java.lang.Object[arr.length]; // creating new array to swap elements to add new between them
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for (int i = index; i < size; i++) {
            newArr[i+1] = arr[i];
        }
        newArr[index] = (T) item;
        arr = newArr;
        size++;
    }

    @Override
    public boolean remove(java.lang.Object item) {
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == item) { // checking if given item contains in array and remove it after
                remove(i);
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public java.lang.Object remove(int index) {
        checkIndex(index); // checking if given index acceptable
        T removed = arr[index]; // store removed item to return after
        for(int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i]; // swap elements to remove element
        }
        size--;
        return removed;
    }

    @Override
    public void clear() {
        this.arr = (T[]) new java.lang.Object[5];
        this.size = 5;
    }

    @Override
    public T get(int index) {
        checkIndex(index); // checking if given index acceptable
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    public int indexOf(java.lang.Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) { // checking if given element contains in array
                return i;
            }
        }
        return -1; // returning -1 if element doesn't exist in array
    }

    public int lastIndexOf(java.lang.Object o) {
        for (int i = size - 1; i >= 0; i--) { // starting from end to find last index
            if (arr[i] == o) { // checking if given element contains in array
                return i;
            }
        }
        return -1; // returning -1 if element doesn't exist in array
    }

    @Override
    public void sort() {
        if (isSortable().equals("int")) { // sorting if array have all integers
            int n = size;
            // bubble sort
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if ((int) arr[j] > (int) arr[j+1])
                    {
                        // swap temp and arr[i]
                        T temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }
        if (isSortable().equals("double")) { // sorting if array have all doubles
            int n = size;
            // bubble sort
            for (int i = 0; i < n-1; i++)
                for (int j = 0; j < n-i-1; j++)
                    if ((Double) arr[j] > (Double) arr[j+1])
                    {
                        // swap temp and arr[i]
                        T temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) { // checking if index acceptable
            throw new IndexOutOfBoundsException(); // throw error if not
        }
    }

    public String isSortable() {
        int intSize = 0;
        int doubleSize = 0;
        for (int i = 0; i < size; i++) {
            try {
                int value = (Integer) arr[i];
                intSize++;
            } catch (ClassCastException e) {
            }
            try {
                double tempD = (Double) arr[i];
                doubleSize++;
            } catch (ClassCastException e) {
            }
        }
        if (intSize == size) {
            return "int";
        }
        if (doubleSize == size) {
            return "double";
        }
        return "0"; // returning 0 if array not acceptable
    }
}