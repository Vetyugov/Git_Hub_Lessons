package Lesson_2;
/*
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
пройти по нему циклом, и числа меньшие 6 умножить на 2;
 */
public class Task_3 {
    public static void main(String[] args) {
        int[] myMassive = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < myMassive.length; i++) {
            if (myMassive[i] < 6) myMassive[i] *= 2;
        }

        for (int val: myMassive) {
            System.out.print(val+" ");
        }
    }
}
