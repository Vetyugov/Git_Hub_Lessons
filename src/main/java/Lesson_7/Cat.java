package Lesson_7;

public class Cat {
    private String name;
    public int appetite;
    private boolean satiety;//сытость
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public void eat(Plate p) {
        if (!satiety) {
            p.decreaseFood(appetite);
            satiety = true;
        }
    }
    public void info(){
        if (!satiety){
            System.out.println("Котик "+name+". Сотстояние: голоден");
        } else {
            System.out.println("Котик "+name+". Сотстояние: сыт");
        }
    }
    public boolean getSatiety(){
        return satiety;
    }

}
