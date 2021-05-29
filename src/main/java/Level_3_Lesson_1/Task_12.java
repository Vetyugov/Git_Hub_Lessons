package Level_3_Lesson_1;
//Для заданий 1,2
import java.util.ArrayList;

public class Task_12 {

    public static void main(String[] args) {

        //Для первого задания
        Integer[] intArray = {12, 20, 34, 54};
        String []strArray = {"apple", "apricot", "pineapple"};


        //проверка для Integer
        printArray(intArray);
        change(intArray, 1, 2);
        printArray(intArray);

        //проверка для String
        printArray(strArray);
        change(strArray, 1, 2);
        printArray(strArray);

        //Для второго задания

        ArrayList newArrayList = new ArrayList();
        System.out.print("Array: ");
        printArray(strArray);
        newArrayList = toArrayList(strArray);
        System.out.print("ArrayList: ");
        printArrayList(newArrayList);

    }

    //Для первого задания
    //Метод, который меняет два элемента массива местами
    public static <T> void change(T[] array, int i, int j){
        T bubble = array[i];
        array[i]= array[j];
        array[j]= bubble;
    }

    //Для первого задания
    public static <T> void printArray(T[] array){
        for (T o:array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    //Для второго задания
    //Метод, который преобразует массив в ArrayList
    public static <T> ArrayList<T> toArrayList(T[] array){
        ArrayList<T> newArrayList = new ArrayList<>();
        for (T o:array) {
            newArrayList.add(o);
        }
        return newArrayList;
    }

    public static <T>void printArrayList(ArrayList<T> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }
}
