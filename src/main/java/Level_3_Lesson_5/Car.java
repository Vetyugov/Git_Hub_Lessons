package Level_3_Lesson_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CountDownLatch waitToStart;
    private static CountDownLatch waitToFinish;
    private static CyclicBarrier cyclicBarrier;
    private static boolean isWin = false;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch waitToStart, CountDownLatch waitToFinish, CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.waitToStart = waitToStart;
        this.cyclicBarrier = cyclicBarrier;
        this.waitToFinish = waitToFinish;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            waitToStart.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (!isWin){
            isWin = true;
            System.out.println(name + " - WIN");
        }
        waitToFinish.countDown();
    }
}
