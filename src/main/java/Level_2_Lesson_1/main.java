package Level_2_Lesson_1;

public class main {
    public static void main(String[] args) {
        //Создаём массив препятствий
        Obstacle [] obstacles = {
                new Treadmill(20),
                new Wall(4),
                new Treadmill(50),
                new Wall(6),
                new Treadmill(100),
                new Wall(10)
        };
        //Создаем массив участников
        actions[] players = {
                new Cat(30, 5),
                new Human(100, 7),
                new Robot(200, 12)
        };

        players[0].run(obstacles[2].getValue());

        int i = 1;
        for (actions player: players) {
            System.out.println("Игрок № "+i);
            i++;
            for (Obstacle obstacle: obstacles) {
                switch (obstacle.getType()){
                    case "Wall":
                        player.jump(obstacle.getValue());
                        break;
                    case "Treadmill":
                        player.run(obstacle.getValue());
                        break;
                }
                if (!player.isDone()){
                    break;
                }
            }
        }

    }

}
