public class Lesson_1 {

    public static void main(String[] args) {
        // Задание 2
        byte a = 10;
        short b = 30_000;
        int c = 20_000_000;
        long d = 1_000_000_000_000L;
        float e = 3.14F;
        double f = 2.23424242342423442F;
        char g = 'g';
        boolean h = false;

        //Задание 3
        System.out.println(countExpr(2.3F, 5.1F, 1, 3));
        //Задание 4
        System.out.println(sumInRange (15, 2));
        //Задание 5
        isPositive (-20);
        //Задание 6
        System.out.println(isPositiveBool(-5));
        //Задание 7
        helloUser("Nikita");
        //Задание 8
        isWeightBearing (1504);
    }

    /*
    Задание 3. Метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    где a, b, c, d – аргументы этого метода, имеющие тип float.
     */
    public static double countExpr(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

    /*
    Задание 4. Метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
    в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */

    private static boolean sumInRange(int a, int b){
        if (a+b >= 10 && a+b <= 20) {
            return true;
        } else return false;
    }

    /*
    Задание 5. Метод, которому в качестве параметра передается целое число, метод должен напечатать
    в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.
     */
    public static void isPositive (int a){
        if (a>=0) System.out.println("Положительное");
        else System.out.println("Отрицательное");
    }

    /*
    Задание 6. Метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    если число отрицательное, и вернуть false если положительное.
     */
    public static boolean isPositiveBool (int a){
        if (a>=0) return false;
        else return true;
    }

    /*
    Задание 7. Метод, которому в качестве параметра передается строка, обозначающая имя.
    Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
     */
    public static void helloUser(String a){
        System.out.println("Привет, " + a+ '!');
    }

    /*
    Задание 8.  Метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static void isWeightBearing (int a){
        if ( (a % 4 == 0 && a % 100 != 0) || (a % 400 ==0) ) {
            System.out.println("Год " + a + " - високосный.");
        } else System.out.println("Год " + a + " - не високосный.");
    }
}