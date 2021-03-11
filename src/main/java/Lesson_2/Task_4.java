package Lesson_2;

import java.util.Arrays;

/*
4. Создать квадратный двумерный целочисленный массив
(количество строк и столбцов одинаковое) и с помощью цикла(-ов)
заполнить его диагональные элементы единицами;
 */
public class Task_4 {
    public static void main(String[] args) {

        int[][] myMassive = new int[5][5];
        for (int i = 0; i < myMassive.length; i++) {
            for (int j = 0; j < myMassive[i].length; j++) {
                if(i==j) myMassive[i][j] = 1;
                System.out.print(myMassive[i][j]+" ");
            }
            System.out.println();
        }
    }
}
