package Level_3_Lesson_1;

import java.util.ConcurrentModificationException;

public class Task3 {
    public static void main(String[] args) {
        //Создаём 2 коробки (с яблоками и апельсинами)
        Box appleBox = new Box();
        Box orangeBox = new Box();
        //Кладём в коробки 3 яблока и 5 апельсинов
        for (int i = 0; i < 3; i++) {
            appleBox.addFruit(new Apple());
        }
        for (int i = 0; i < 5; i++) {
            orangeBox.addFruit(new Orange());
        }

        //Проверяем сколько в каждой коробке фруктов
        System.out.println("Вес первой коробки с яблоками - "+ appleBox.getWeight()+" у.е.");
        System.out.println("Вес коробки с апельсинами - "+ orangeBox.getWeight()+" у.е.");

        //Создаём ещё одну коробку с яблоками и кладём туда 10 яблок
        Box appleBox2 = new Box();
        for (int i = 0; i < 10; i++) {
            appleBox.addFruit(new Apple());
        }

        //Пересыпаем яблоки из второй коробки в первую
        appleBox2.passBox(appleBox);

        //Проверяем вес первой коробки
        System.out.println("Вес первой коробки с яблоками - "+ appleBox.getWeight()+" у.е.");
        //Проверяем вес второй коробки
        System.out.println("Вес второй коробки с яблоками - "+ appleBox2.getWeight()+" у.е.");

        //Сравним коробку яблок с коробкой апельсинов
        System.out.println("Вес первой коробки яблок такой же, что и вес коробки апельсинов? "+ appleBox.compare(orangeBox));

        //Пытаемся перемешать аблоки с апельсинами
        try {
            appleBox.passBox(orangeBox);
        } catch (ConcurrentModificationException e){
            System.out.println("Нельзя перемешивать коробки с разными фруктами");
        }

        System.out.println("Вес коробки с апельсинами - "+ orangeBox.getWeight()+" у.е.");


    }
}
