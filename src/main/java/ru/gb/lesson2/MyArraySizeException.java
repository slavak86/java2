package ru.gb.lesson2;

public class MyArraySizeException extends Exception {

    MyArraySizeException(int requiredSize) {
        super(String.format("Размерность массива отличается от %d%n", requiredSize));
    }
}
