package Level_2_Lesson_1;

public class Wall extends Obstacle {
    public final String TYPE = "Wall";
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String getType(){
        return "Wall";
    }
    @Override
    public int getValue(){
        return height;
    }



}
