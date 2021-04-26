package Level_2_Lesson_3;
//Всё верно)

import java.util.HashMap;
import java.util.Map;


public class Task_1 {

    public static void main(String[] args) {
        String [] words = { "apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli","orange", "carrot", "cherry","apple", "garlic","orange", "grape", "apple", "melon", "leak",
                "kiwi", "mango", "apple", "mushroom","apricot", "nut"};
        HashMap<String, Integer> unicWords = new HashMap<>();

        for (String word: words) {
            if (unicWords.containsKey(word)) {
                unicWords.put(word, unicWords.get(word) + 1);
            }
            else {
                unicWords.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> o: unicWords.entrySet()) {
            System.out.printf("Уникальное слово: %10s, количество: %d \n",o.getKey(),o.getValue() );
        }

    }




}
