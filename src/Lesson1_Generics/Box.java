package Lesson1_Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Task 3.b.
class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    Box() {
        fruits = new ArrayList<>();
    }

    Box(T... arr) {
        this();
        addFruits(arr);
    }

    // Task 3.d
    float getWeight() {
        float weight = 0f;
        if (fruits.size() != 0) {
            for (T fruit : fruits) {
                weight += fruit.getWeight();
            }
        }
        return weight;
    }

    // Task 3.e
    boolean compare(Box<?> box) {
        if (box != null) {
            return Math.abs(getWeight() - box.getWeight()) < 0.0001f;
        }
        return false;
    }

    // Task 3.f
    void pourInto(Box<? super T> target) {
        if (target != null) {
            target.fruits.addAll(fruits);
            fruits.clear();
        }
    }

    // Task 3.g
    void addFruits(T... arr) {
        if (arr != null && arr.length != 0) {
            fruits.addAll(Arrays.asList(arr));
        }
    }

    // Task 3.g overloaded
    void addFruits(List<T> list) {
        if (list != null && !list.isEmpty()) {
            fruits.addAll(list);
        }
    }

}