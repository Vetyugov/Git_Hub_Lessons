package Level_2_Lesson_2;
/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого
   размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
   Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
   должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
   и вывести результат расчета. (исправил ошибки)
 */
public class Main {

    public static void main(String[] args) {
        String [][] myArray1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        System.out.println("Массив № 1");
        arrayToIntAndSum(myArray1);

        String [][] myArray2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "в"},
                {"13", "14", "15", "16"}
        };
        System.out.println("Массив № 2");
        arrayToIntAndSum(myArray2);

        String [][] myArray3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "в"},
                {"13", "14", "15", "16"},
                {"13", "14", "15", "16"}
        };
        System.out.println("Массив № 3");
        arrayToIntAndSum(myArray3);
    }




    public static void arrayToIntAndSum(String[][] myArray) throws MyArrayDataException, MyArraySizeException {

        try{
            if (myArray.length != 4){
                throw new MyArraySizeException();
            }
            int sum = 0;
            for (int i = 0; i <myArray.length ; i++) {
                if (myArray[i].length != 4){
                    throw new MyArraySizeException();
                }
                for (int j = 0; j < myArray[i].length; j++) {
                    try {
                        sum += Integer.parseInt(myArray[i][j]);
                    } catch ( NumberFormatException ex){
                        throw new MyArrayDataException("строка "+i+", столбец "+j);
                    }
                }
            }
            System.out.println(sum);

        } catch (MyArraySizeException e){ //Если массив не подходящего размера
            e.printMessage();
        } catch ( MyArrayDataException ex){         //Если в массиве не число
            ex.printMessage();
        }


    }


}

