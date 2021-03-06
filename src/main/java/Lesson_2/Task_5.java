package Lesson_2;

import java.util.Random;

/*
5. ** Задать одномерный массив и найти в нем
минимальный и максимальный элементы (без помощи интернета);
 */
public class Task_5 {
    public static void main(String[] args) {
        //создание массива с рандомными значениями
        int[] myMassive = new int[5];
        for (int i = 0; i < myMassive.length; i++) {
            myMassive[i]= (int)(Math.random()*100);
        }

        int maxVal = myMassive[0];
        int minVal = myMassive[0];
        for (int val:myMassive) {
            if (val>maxVal){
                maxVal = val;
            } else if (val<minVal) minVal = val;
        }

        for (int val: myMassive) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("Максимальный элемент массива - " + maxVal);
        System.out.println("Минимальный элемент массива - " + minVal);
    }
}
