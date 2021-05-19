package Level_3_Lesson_1;
//Для заданий 1,2
import java.util.ArrayList;

public class Task_12 {

    public static void main(String[] args) {

        //Для первого задания
        Integer[] intArray = {12, 20, 34, 54};
        String []strArray = {"apple", "apricot", "pineapple"};


        //проверка для Integer
        GenericClass<Integer> forIntChange = new GenericClass<>();
        forIntChange.printArray(intArray);
        forIntChange.change(intArray, 1, 2);
        forIntChange.printArray(intArray);

        //проверка для String
        GenericClass<String> forStrChange = new GenericClass<>();
        forStrChange.printArray(strArray);
        forStrChange.change(strArray, 1, 2);
        forStrChange.printArray(strArray);

        //Для второго задания
        GenericClass<String> forArrayToArrayList = new GenericClass<>();
        ArrayList newArrayList = new ArrayList();
        System.out.print("Array: ");
        forArrayToArrayList.printArray(strArray);
        newArrayList = forArrayToArrayList.toArrayList(strArray);
        System.out.print("ArrayList: ");
        forArrayToArrayList.printArrayList(newArrayList);

    }
}
