package Level_3_Lesson_1;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruitBox;
    private int countFruit = 0;
    private float weightFruit;



    public Box() {
        this.fruitBox = new ArrayList<>();
    }

    public void addFruit(T fruit){
        this.fruitBox.add(fruit);
        countFruit++;
        if (countFruit == 1) {
            weightFruit = fruit.getWeight();
        }
    }

    public float getWeight(){
        return countFruit * weightFruit;
    }

    public boolean compare (Box box){
        if (countFruit*weightFruit == box.getWeight()){
            return true;
        } else {
            return false;
        }
    }

    public void passBox (Box<T> box){
        for (T o:fruitBox) {
            box.addFruit(o);
            fruitBox.remove(o);
        }

    }

}
