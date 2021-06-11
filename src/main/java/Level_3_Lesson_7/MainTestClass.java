package Level_3_Lesson_7;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTestClass {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            Class someClass = SetOfTests.class;
            start(someClass);
    }

    public static void start(Class testClass) throws IllegalAccessException, InstantiationException {
        //Создаём экземпляр класса testClass

        SetOfTests tests = (SetOfTests) testClass.newInstance();
        Method[] methods = SetOfTests.class.getDeclaredMethods();

        int countBefore = 0;
        int countAfter = 0;
        Method beforeMethod = null;
        Method afterMethod = null;
        Method mToDo;

        //Ищем методы с аннотацией BeforeSuite и AfterSuite
        for (Method m: methods) {
            if (m.getAnnotation(BeforeSuite.class) != null){
                countBefore++;
                if (countBefore == 2){
                    throw new RuntimeException("Два метода с аннотацией BeforeSuite");
                }
                beforeMethod = m;
            }
            if (m.getAnnotation(AfterSuite.class) != null){
                countAfter++;
                if (countAfter == 2){
                    throw new RuntimeException("Два метода с аннотацией BeforeSuite");
                }
                afterMethod = m;
            }
        }

        //Запускаем метод BeforeSuite
        try {
            mToDo = SetOfTests.class.getDeclaredMethod(beforeMethod.getName());
            mToDo.invoke(tests);
        } catch (NoSuchMethodException | InvocationTargetException e){
            e.printStackTrace();
        }

        //Ищем методы с аннотацией Test
        Method[] testMethods = new Method[methods.length-2];
        int i = 0;
        for (Method m: methods) {
            if (m.getAnnotation(Test.class) != null) {
                testMethods[i] = m;
                i++;
            }
        }

        //Сортируем методы по значению value. SortedMap использовать нельзя, т.к. Могуть быть методы с динаковым значением value
        for (i = 0; i < testMethods.length-1; i++) {
            for (int j = i+1; j < testMethods.length; j++) {
                    if (testMethods[j].getAnnotation(Test.class).value() > testMethods[i].getAnnotation(Test.class).value()){
                        Method temp = testMethods[i];
                        testMethods[i] = testMethods[j];
                        testMethods[j] = temp;
                    }
            }
        }

        //Запускаем методы из сортированного массива
        for (Method m: testMethods) {
            if (m.getAnnotation(Test.class) != null){
                try {
                    mToDo = SetOfTests.class.getDeclaredMethod(m.getName());
                    mToDo.invoke(tests);
                } catch (NoSuchMethodException | InvocationTargetException e){
                    e.printStackTrace();
                }

            }
        }


        //Запускаем метод AfterSuite
        try {
            mToDo = SetOfTests.class.getDeclaredMethod(afterMethod.getName());
            mToDo.invoke(tests);
        } catch (NoSuchMethodException | InvocationTargetException e){
            e.printStackTrace();
        }

    }
}
