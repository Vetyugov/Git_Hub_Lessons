package Level_2_Lesson_1;

public class Robot implements actions {

    private int maxDistance;
    private int maxHeight;
    private boolean ability = false;

    public Robot(int maxDistance, int maxHeight) {
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    public void run (int distance){
        if (maxDistance >= distance){
            System.out.println("Пробежал!!!");
            ability = true;
        } else {
            System.out.println("FAIL");
            ability = false;
        }
    }

    public void jump(int height){
        if (maxHeight >= height){
            System.out.println("Перепрыгнул!!!");
            ability = true;
        } else {
            System.out.println("FAIL");
            ability = false;
        }
    }

    public boolean isDone(){
        return ability;
    }
}
