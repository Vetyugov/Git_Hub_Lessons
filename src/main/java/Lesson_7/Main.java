package Lesson_7;

import java.util.Scanner;

public class Main {
    private static int COUNTCAT = 0;

    public static void main(String[] args) {
        Plate plate = new Plate(20);
        Cat [] cats = new Cat[10];
        while (true){
            System.out.println("Создано котиков "+COUNTCAT+"/10");
            System.out.println("[1] - создать котика;");
            System.out.println("[2] - покортить определённого котика;");
            System.out.println("[3] - покормить всех котиков;");
            System.out.println("[4] - узнать сколько еды осталось в тарелке");
            System.out.println("[5] - добавить еду в тарелку");
            System.out.println("[6] - вывести список всех котиков");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()){
                case 1:
                    createCat(cats);
                    break;
                case 2:
                    eatCat(plate, cats);
                    break;
                case 3:
                    eatAllCat(plate, cats);
                    break;
                case 4:
                    plate.info();
                    break;
                case 5:
                    addFood(plate);
                    break;
                case 6:
                    printList(cats);
                    break;
            }
        }
    }

    private static void createCat(Cat[] cats){
        if (COUNTCAT >=10){
            System.out.println("Превышел лимит котиков");
        } else {
            COUNTCAT++;
            System.out.println("Введите имя кота:");
            Scanner scanner = new Scanner(System.in);
            String nameCat = scanner.next();
            do{
                System.out.println("Введите аппатит кота от 1 до 10");
                int appetitCat = scanner.nextInt();
                if (appetitCat<=10 && appetitCat >=1){
                    cats[COUNTCAT-1] = new Cat(nameCat, appetitCat);
                    break;
                }
            } while (true);
        }
    }

    private static void eatCat(Plate plate, Cat[] cats){
        System.out.println("Введите номер котика, которого хотите покормить");
        Scanner scanner = new Scanner(System.in);
        int numCat = scanner.nextInt();
        if (numCat >= COUNTCAT){
            System.out.println("Котика с таким номером ещё не существует(");
        } else {
            cats[numCat].eat(plate);
        }
    }
    
    private static void eatAllCat(Plate plate, Cat[] cats){
        int needFood = 0;
        for (int i = 0; i < COUNTCAT; i++) {
            if (!cats[i].getSatiety()){
                needFood = needFood + cats[i].appetite;
            }
        }

        System.out.println("Требуется еды: "+needFood);

        if (needFood <= plate.getFood()){
            for (int numCat = 0; numCat < COUNTCAT; numCat++) {
                cats[numCat].eat(plate);
            }
        } else {
            System.out.println("Нельзя покормить всех котиков");
        }

    }

    private static void printList(Cat[] cats){
        for (int numCat = 0; numCat < COUNTCAT; numCat++) {
            System.out.print(numCat+" - ");
            cats[numCat].info();
        }
    }

    private static void addFood(Plate plate){
        System.out.println("Сколько еды хотите добавить в тарелку?");
        Scanner scanner = new Scanner(System.in);
        int food = scanner.nextInt();
        plate.addFood(food);
    }
}
