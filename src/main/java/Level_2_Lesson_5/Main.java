package Level_2_Lesson_5;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr2 = new float[size];


    public static void main(String[] args) throws InterruptedException {
        method_1();
        method_2();

        /*Реализовал методы так, чтобы они обрабатывали одинаково большой массив, т.к. во втором методе если не менять значение i в формуле,
        то второй поток будет обрабытывать массив так же как и первый и получится большой массив, состоящий из двух одиаковых половинок.
         */
        if (Arrays.equals(arr, arr2)){
            System.out.println("масивы равны");
        } else {
            System.out.println(arr2[0]);
            System.out.println(arr[0]);

            System.out.println(arr2[200]);
            System.out.println(arr[200]);

            System.out.println(arr2[10000000-1]);
            System.out.println(arr[10000000-1]);
        }

    }

    public static void mathOperation(float[] array, int nullPoint){
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (float) ((i+nullPoint) / 5)) * Math.cos(0.2f + (float) ((i+nullPoint) / 5)) * Math.cos(0.4f + (float) ((i+nullPoint) / 2)));
        }
    }

    public static void method_1(){
        //Создаёт одномерный длинный масси;

        //Заполняют этот массив единицами;
        Arrays.fill(arr, 1);
        //Засекают время выполнения;
        long a = System.currentTimeMillis();
        //Проходят по всему массиву и для каждой
        // ячейки считают новое значение по формуле:
        mathOperation(arr, 0);
        // Проверяется время окончания метода;
        //В консоль выводится время работы:
        System.out.println("Время выполнения первого метода:" + (System.currentTimeMillis() - a));
    }


    private static void method_2() throws InterruptedException {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        //Создаёт одномерный длинный масси;

        //Заполняет этот массив единицами;
        Arrays.fill(arr2, 1);
        //Засекают время выполнения;
        long a = System.currentTimeMillis();

        //Разбивает на 2 массива
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);
        //Проходят по всему массиву и для каждой
        // ячейки считают новое значение по формуле:
        Thread thread1 = new Thread(() -> mathOperation(a1, 0));
        Thread thread2 = new Thread(() -> mathOperation(a2, h));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();


        //Склеиваем обратно массивы
        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);
        // Проверяется время окончания метода;
        //В консоль выводится время работы:
        System.out.println("Время выполнения второго метода:"+ (System.currentTimeMillis() - a));
    }
}
