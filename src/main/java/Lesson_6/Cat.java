package Lesson_6;

public class Cat extends Animal{
    private String name;
    private static int countCat = 0;

    public Cat(String name) {
        this.name = name;
        countCat++;
        System.out.println("Всего создано " + countCat + " котов");
    }

    public void run (int s){
        if (s<=200){
            super.run(name, s);
        } else {
            System.out.println("Коты не умеют бегать "+ s+" метров");
        }
    }

    public void swim (int s){
            System.out.println("Коты не умеют плавать");
    }


}
