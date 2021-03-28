package Lesson_7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (food>=n){
            food -= n;
        } else {
            System.out.println("Нельзя покормить котика( Осталось мало еды");
        }
    }

    public void info() {
        System.out.println("В тарелке: " + food+" еды");
    }

    public void addFood(int n){
        this.food = food + n;
    }

    public int getFood() {
        return food;
    }
}
