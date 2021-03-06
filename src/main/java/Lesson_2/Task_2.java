package Lesson_2;
/*
2. Задать пустой целочисленный массив размером 8.
С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 */
public class Task_2 {
    public static void main(String[] args) {

        int[] myMassive = new int[8];

        for (int i = 0; i<myMassive.length; i++ ){
            myMassive[i] = i*3;
        }

        for (int val:myMassive) {
            System.out.print(val+" ");
        }
    }

}
