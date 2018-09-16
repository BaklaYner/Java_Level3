package Lesson1_Generics;

// Task 3.a
abstract class Fruit {
    private final float weight;

    Fruit(float weight) {
        this.weight = weight;
    }

    float getWeight() {
        return weight;
    }

}