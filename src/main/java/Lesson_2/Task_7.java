package Lesson_2;
/*
7. **** Написать метод, которому на вход подается одномерный массив и число n
(может быть положительным, или отрицательным), при этом метод должен сместить
все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
задачи нельзя пользоваться вспомогательными массивами. Примеры:
[ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
[ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
При каком n в какую сторону сдвиг можете выбирать сами.
 */
public class Task_7 {
    public static void main(String[] args) {
        int[] myArray = {3, 5, 6, 1};
        int n = -2;
        shiftArray(myArray, n);
        for (int val: myArray) {
            System.out.print(val + " ");
        }
    }
    // Не придумал, как можно избежать 2х почти одинаковых if-ов
    public static void shiftArray( int[] myArray, int n){
        int temp1 ,temp2;
        if (n>=0){
            for (int i = 0; i < n; i++) {
                temp2 = myArray[myArray.length-1];
                for (int j = 0; j < myArray.length; j++) {
                    temp1 = myArray[j];
                    myArray[j] = temp2;
                    temp2 = temp1;
                }
            }
        }
        else {
            for (int i = 0; i < Math.abs(n); i++) {
                temp2 = myArray[0];
                for (int j = myArray.length - 1; j >= 0; j--) {
                    temp1 = myArray[j];
                    myArray[j] = temp2;
                    temp2 = temp1;
                }
            }
        }
    }
}
