package ru.gb.lesson2;

public class App {

    static final int SIZE = 4;
    static final String[][] array = {
            {"1", "2", "3", "4"},
            {"2", "3", "4", "5"},
            {"3", "4", "5", "6"},
            {"4", "5", "b", "7"}
    };

    public static void main(String[] args) {
        printArray(array);

//        String[][] arrays = new String[1][];


//        String[][] arr2 = {{"1", "2", "2", "3"},
//                {"2", "3", "4", "5"},
//                {"3", "4", "5", "6"},
//                {"4", "5", "6", "7"}};

//        String[][] arr3 = {{"1", "2", "3", "4"},
//                {"2", "3", "4", "5"},
//                {"3", "4", "5", "6"},
//                {"4", "5", "6", "7"}};
//        arrays[0] = arr1;
//        arrays[1] = arr2;
//        arrays[2] = arr3;

//        for (String[] arr : arrays) {
//            printArray(arr1);



            try {
                System.out.printf("Сумма элементов массива равна %s%n%n", getSum(array));
            } catch (MyArrayDataException | MyArraySizeException ex) {
                System.out.println(ex);
            }
        }



    private static int getSum(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != SIZE) {
            throw new MyArraySizeException(SIZE);
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(SIZE);
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    private static void printArray(String[][] array) {
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.printf("%4s", string);
            }
            System.out.println();
        }
    }


}