package ru.gb.lesson2;

public class MyArrayDataException extends Exception{

    MyArrayDataException(int row, int col) {
        super(String.format("В элементе массива [%d, %d] неправильный тип данных%n", row, col));
    }
}
