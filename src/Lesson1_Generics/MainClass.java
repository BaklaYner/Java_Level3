package Lesson1_Generics;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        // Call for task 1 and 2.
        MainClass obj = new MainClass();

        Integer[] arr = new Integer[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Integer[] arr2 = null;
        Integer[] arr3 = new Integer[0];
        String[] arrStr = {"Hello", "world", "Java", "top", "brain"};

        System.out.println("arr before swap: " + Arrays.toString(arr));
        System.out.println("arr2 before swap: " + Arrays.toString(arr2));
        System.out.println("arr3 before swap: " + Arrays.toString(arr3));
        System.out.println("arrStr before swap: " + Arrays.toString(arrStr));
        System.out.println();

        obj.swapTwoElements(arr, 0, 4);
        obj.swapTwoElements(arr2, 0, 4);
        obj.swapTwoElements(arr3, 0, 4);
        obj.swapTwoElements(arrStr, 0, 4);

        System.out.println("arr after swap: " + Arrays.toString(arr));
        System.out.println("arr2 after swap: " + Arrays.toString(arr2));
        System.out.println("arr3 after swap: " + Arrays.toString(arr3));
        System.out.println("arrStr after swap: " + Arrays.toString(arrStr));
        System.out.println();

        System.out.println("ArrayList from arr: " + obj.arrayToArrayList(arr));
        System.out.println("ArrayList from arr2: " + obj.arrayToArrayList(arr2));
        System.out.println("ArrayList from arr3: " + obj.arrayToArrayList(arr3));
        System.out.println("ArrayList from arrStr: " + obj.arrayToArrayList(arrStr));
        System.out.println();

        // Call for task 3.
        Apple[] apples = new Apple[15];
        for (int i = 0; i < apples.length; i++) {
            apples[i] = new Apple();
        }
        Box<Apple> boxWith15Apples = new Box<>(apples);

        Orange[] oranges = new Orange[10];
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] = new Orange();
        }
        Box<Orange> boxWith10Oranges = new Box<>();
        boxWith10Oranges.addFruits(oranges);

        Box<Apple> boxWith2Apples = new Box<>();
        boxWith2Apples.addFruits(new Apple(), new Apple());

        System.out.println("Weight of boxWith2Apples is - " + boxWith2Apples.getWeight());
        System.out.println("Weight of boxWith15Apples is - " + boxWith15Apples.getWeight());
        System.out.println("Weight of boxWith10Oranges is - " + boxWith10Oranges.getWeight());
        System.out.println("Weight of boxWith15Apples is equal to weight of boxWith10Oranges: " +
                boxWith15Apples.compare(boxWith10Oranges));
        System.out.println();

        System.out.println("Pour apples from boxWith2Apples to boxWith15Apples...");
        boxWith2Apples.pourInto(boxWith15Apples);
        System.out.println("New weight of boxWith2Apples is - " + boxWith2Apples.getWeight());
        System.out.println("New weight of boxWith15Apples is - " + boxWith15Apples.getWeight());
        System.out.println("Now weight of boxWith15Apples is equal to weight of boxWith10Oranges: " +
                boxWith15Apples.compare(boxWith10Oranges));
    }

    // Task 1.
    private void swapTwoElements(Object[] arr, int firstInd, int secondInd) {
        if (arr != null &&
                (firstInd >= 0 && firstInd < arr.length) &&
                (secondInd >= 0 && secondInd < arr.length)) {
            Object temp = arr[firstInd];
            arr[firstInd] = arr[secondInd];
            arr[secondInd] = temp;
        }
    }

    // Task 2.
    private <T> ArrayList<T> arrayToArrayList(T... arr) {
        if (arr != null) {
            return new ArrayList<>(Arrays.asList(arr));
        }
        return null;
    }

    // Task 2. Version 2.
    private <T> ArrayList<T> arrayToArrayList2(T... arr) {
        if (arr != null) {
            ArrayList<T> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        }
        return null;
    }

}