package Lesson_6;

public class Dog extends Animal {
    private String name;
    private static int countDog = 0;
    public Dog (String name){
        this.name = name;
        countDog++;
        System.out.println("Всего создано " + countDog+ " собак");
    }

    public void run (int s){
        if (s<=500){
            super.run(name, s);
        } else {
            System.out.println("Собаки не умеют бегать "+ s+" метров");
        }
    }

    public void swim (int s){
        if (s<=10){
            super.swim(name, s);
        } else {
            System.out.println("Собаки не умеют плавать "+ s+" метров");
        }
    }
}
