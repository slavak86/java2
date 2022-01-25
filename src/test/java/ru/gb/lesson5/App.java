package ru.gb.lesson5;

import java.util.Arrays;

public class App {

    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;

    public static void main(String[] args) {


        firstMethod(createArray());
        secondMethod(createArray());
    }

    private static float[] createArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        return arr;
    }

    private static float[] calculation(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    private static void firstMethod(float[] arr) {
        createArray();
        long startTime = System.currentTimeMillis();
        calculation(arr);
        System.out.println("Время в одном потоке " + (System.currentTimeMillis() - startTime + "ms"));


    }

    private static void secondMethod(float[] arr) {
        createArray();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread oneThread = new Thread(new Runnable() {
            @Override
            public void run() {
                calculation(arr1);
            }
        });
        oneThread.start();

        Thread twoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                calculation(arr2);
            }
        });
        twoThread.start();

        try {
            oneThread.join();
            twoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, arr2.length);
        System.out.println("Время в двух потоках " + (System.currentTimeMillis() - startTime + "ms"));


    }
}
