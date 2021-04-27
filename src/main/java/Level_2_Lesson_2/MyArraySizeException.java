package Level_2_Lesson_2;
//Исключение 2

class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    MyArraySizeException(){
    }
    public void printMessage(){
        System.out.println("MyArraySizeException: Выход за границы массива");
    }
}