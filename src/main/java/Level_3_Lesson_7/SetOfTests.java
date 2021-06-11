package Level_3_Lesson_7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test{
    int value() default 10;
}

public class SetOfTests {

    @org.testng.annotations.BeforeSuite
    public void firstOfAll(){
        System.out.println("BeforeSuite выполнен");
    }
//    @org.testng.annotations.BeforeSuite
//    public void notfirstOfAll(){
//        System.out.println("BeforeSuite выполнен");
//    }

    @Test(value = 9)
    public void test_9(){
        System.out.println("Тест с приоритетом = 9");
    }

    @Test(value = 5)
    public void test_5(){
        System.out.println("Тест с приоритетом = 5");
    }

    @Test(value = 4)
    public void test_4(){
        System.out.println("Тест с приоритетом = 4");
    }

    @Test(value = 8)
    public void test_8(){
        System.out.println("Тест с приоритетом = 8");
    }

    @Test(value = 3)
    public void test_3(){
        System.out.println("Тест с приоритетом = 3");
    }

    @org.testng.annotations.AfterSuite
    public void inTheEnd(){
        System.out.println("AfterSuite выполнен");
    }


}
