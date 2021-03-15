package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Task_3 {
/*
 * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
 * Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
 */
        public static int SIZE;
        public static int SIZEWIN;
        public static final char DOT_EMPTY = '·';
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static char [][] mas;
        public static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            do {
                System.out.println("Введите размер квадратного поля для игры (больше 2) SIZE = ");
                SIZE = sc.nextInt();
            } while (!(SIZE > 2));
            do {
                System.out.println("Сколько фишек необходимо поставить в ряд, чтобы победить? SIZEWIN=");
                SIZEWIN = sc.nextInt();
            } while (!(SIZEWIN <=SIZE && SIZEWIN>1));
            mas = new char[SIZE][SIZE];
            initMassive();
            printArray();
            int countTries = 1;
            while (true){
                userTurn();
                printArray();
                if (countTries == SIZE*SIZE){
                    System.out.println("Ничья");
                    break;
                }
                if (countTries > SIZEWIN-1) {
                    if (checkWin(DOT_X)) {
                        System.out.println("Вы победили!!!");
                        break;
                    };
                }
                aiTurn();
                System.out.println("Ход ИИ");
                printArray();
                if (countTries > SIZEWIN-1){
                    if (checkWin(DOT_O)) {
                        System.out.println("ИИ победил...");
                        break;
                    }
                }
                countTries++;
            }
            sc.close();
        }


        //Инициализация массива
        public static void initMassive(){

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    mas[i][j] = DOT_EMPTY;
                }
            }
        }

        //Вывод доски на экран
        public static void printArray(){
            for (int i = 0; i <= SIZE ; i++) {
                System.out.print(i+" ");
            }
            System.out.println();
            for (int i = 0; i < SIZE ; i++) {
                System.out.print(i+1 + " ");
                for (int j = 0; j < SIZE ; j++) {
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
        }

        //Ход игрока
        public static void userTurn(){
            int x, y;
            do {
                System.out.println("Введите позицию клетки для постановки крестика");
                System.out.println("Первая цифра - столбец, вторая - строка");
                y = sc.nextInt(); //столбец
                x = sc.nextInt(); //строка
            } while (!isCellValid(x-1, y-1));
            mas[x-1][y-1] = DOT_X;
        }

        //Ход ИИ
        public static void aiTurn(){
            Random random = new Random();
            int x, y;
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
            mas[x][y] = DOT_O;
        }

        //Проверка корректности введённых данных
        private static boolean isCellValid(int x, int y){
            if (x>=0 && x<SIZE && y>=0 && y<SIZE){
                if (mas[x][y]==DOT_EMPTY){
                    return true;
                } else return false;
            } else return false;
        }

        // Проверка победы
        private static boolean checkWin(char checkDot){
            int countD = 0; //счетчик подряд идущих checkDot на главных диагоналях
            int countD1 = 0;//счетчик подряд идущих checkDot на главных диагоналях
            int countDD = 0; //счетчик подряд идущих checkDot на побочных диагоналях
            int countDD1 = 0;//счетчик подряд идущих checkDot на побочных диагоналях
            //проверка диагональных элементов
            for (int j = 0; j < 1+(SIZE-SIZEWIN); j++) {
                for (int i = 0; i < SIZE-j; i++) {
                    //на главных диагоналях
                    if(mas[i+j][i] == checkDot) {
                        countD++;
                        if (countD == SIZEWIN) return true;
                    }
                    else countD = 0;
                    if (mas[i][i+j] == checkDot){
                        countD1 ++;
                        if (countD1 == SIZEWIN) return true;
                    } else countD1 = 0;

                    //на побочной диагонали
                    if(mas[i+j][SIZE-i-1] == checkDot) {
                        countDD++;
                        if (countDD == SIZEWIN) return true;
                    }
                    else countDD = 0;
                    if (mas[i][SIZE-(i+j)-1] == checkDot){
                        countDD1 ++;
                        if (countDD1 == SIZEWIN) return true;
                    } else countDD1 = 0;
                }
                countD = 0;
                countDD = 0;
                countDD1 = 0;
                countD1 = 0;

            }

            //проверка по строкам и столбцам
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (mas[i][j] == checkDot) {
                        countD++;
                        if(countD == SIZEWIN) return true;
                    }
                    else countD = 0;
                    if (mas[j][i] == checkDot) {
                        countDD++;
                        if (countDD == SIZEWIN) return true;
                    }
                    else countDD = 0;
                }
                countD = 0;
                countDD = 0;


            }
            return false;
        }
}


