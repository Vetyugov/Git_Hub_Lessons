package Level_2_Lesson_1;

//Беговая дорожка
public class Treadmill extends Obstacle{
    private int distance = 100;
    public final String TYPE = "Treadmill";

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public String getType(){
        return "Treadmill";
    }

    @Override
    public int getValue(){
        return distance;
    }


}
