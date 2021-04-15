package Level_2_Lesson_2;
//Исключение

class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    MyArraySizeException(){
    }
    public void printMessage(){
        System.out.println("MyArraySizeException: Выход за границы массива");
    }
}