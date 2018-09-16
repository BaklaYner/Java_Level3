package Lesson1_Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Task 3.b.
class Box<T extends Fruit> {
    private ArrayList<T> fruits;
    private float weight;

    Box() {
        fruits = new ArrayList<>();
        weight = 0;
    }

    Box(T... arr) {
        this();
        addFruits(arr);
    }

    // Task 3.d
    float getWeight() {
        return weight;
    }

    // Task 3.e
    boolean compare(Box<?> box) {
        if (box != null) {
            return weight == box.weight;
        }
        return false;
    }

    // Task 3.f
    void pourInto(Box<T> target) {
        if (target != null) {
            target.addFruits(fruits);
            fruits.clear();
            weight = 0;
        }
    }

    // Task 3.g
    void addFruits(T... arr) {
        if (arr != null && arr.length != 0) {
            fruits.addAll(Arrays.asList(arr));
            for (T fruit : arr) {
                weight += fruit.getWeight();
            }
        }
    }

    // Task 3.g overloaded
    void addFruits(List<T> list) {
        if (list != null && !list.isEmpty()) {
            fruits.addAll(list);
            for (T fruit : list) {
                weight += fruit.getWeight();
            }
        }
    }

}