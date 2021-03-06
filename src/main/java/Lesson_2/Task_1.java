package Lesson_2;
/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. 
Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. 
С помощью цикла и условия заменить 0 на 1, 1 на 0;
 */
public class Task_1 {
    public static void main(String[] args) {
        //Инициализация массива
        int[] myMassive = {1,1,0,0,1,0,1,1,0,0};
        //Изменение массива
        for (int i = 0; i<myMassive.length; i++) {
            if (myMassive[i] == 1) myMassive[i] = 0;
            else myMassive[i] = 1;
        }
        //Вывод массива
        for (int val:myMassive) {
            System.out.print(val+" ");
        }


    }
}
