package Level_3_Lesson_1;
//Для заданий 1,2
import java.util.ArrayList;

public class GenericClass <T>{
    //Для первого задания
    //Метод, который меняет два элемента массива местами
    public void change(T[] array, int i, int j){
        T bubble = array[i];
        array[i]= array[j];
        array[j]= bubble;
    }

    //Для первого задания
    public void printArray(T[] array){
        for (T o:array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    //Для второго задания
    //Метод, который преобразует массив в ArrayList
    public ArrayList<T> toArrayList(T[] array){
        ArrayList<T> newArrayList = new ArrayList<>();
        for (T o:array) {
            newArrayList.add(o);
        }
        return newArrayList;
    }

    public void printArrayList(ArrayList<T> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
    }
}
