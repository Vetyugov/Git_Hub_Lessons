package Lesson_3;

import java.util.Random;
import java.util.Scanner;

/*
String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
apple – загаданное
apricot - ответ игрока
ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
Для сравнения двух слов посимвольно можно пользоваться:
String str = "apple";
char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
Играем до тех пор, пока игрок не отгадает слово.
Используем только маленькие буквы.
 */
public class Task_2 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        Random rand = new Random();
        String mainWord = words[rand.nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        do {
            System.out.println("Угадай слово");
            String readWord = scanner.nextLine();
            if (mainWord.equals(readWord)){
                System.out.println("Вы угадали!");
                isTrue = true;
            } else makeMask(mainWord, readWord);
        } while (!isTrue);
        scanner.close();
    }

    public static void makeMask(String mainWord, String readWord) {
        for (int i = 0; i < mainWord.length(); i++) {
            if (readWord.length()-1 < i){
                System.out.print("#");
            } else if (mainWord.charAt(i) == readWord.charAt(i)){
                System.out.print(mainWord.charAt(i));
            } else System.out.print("#");
        }
        for (int i = mainWord.length(); i < 15; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
