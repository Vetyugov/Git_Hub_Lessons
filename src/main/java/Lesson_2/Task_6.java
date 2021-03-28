package Lesson_2;
/*
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой
части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы
в массив не входят.
 */
public class Task_6 {
    public static void main(String[] args) {
        int[] myArray = {2, 2};
        if (myArray.length <=1){
            System.out.println("Массив, состоящий из 1 элемента и менее не может быть симметричным");
        }
        else System.out.println(checkBalance(myArray));
    }
    //Чтобы метод выдавал только true или false необходимо закоментить все выводы в методе,
    // а так зато выводит как в условии))))
    public static boolean checkBalance (int[] myArray){
        int sumLeft = myArray[0];
        int sumRight = myArray[myArray.length-1];
        int i = 1, j = 1;
        for (int k = 0; k < myArray.length; k++) {
            if (sumLeft <= sumRight && i+j != myArray.length) {
                sumLeft += myArray[i];
                i++;
            } else if (sumLeft > sumRight) {
                sumRight += myArray[myArray.length-1-j];
                j++;
            } else if (sumLeft == sumRight && i+j == myArray.length){
                for (int l = 0; l < myArray.length; l++) {
                    if (l == i-1) {
                        System.out.print(myArray[l] + " || ");
                    } else System.out.print(myArray[l] + " ");
                }
                System.out.print("-> ");
                return true;
            }

        }
        return false;
    }
}

