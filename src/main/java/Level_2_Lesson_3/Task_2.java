package Level_2_Lesson_3;

public class Task_2 {
    public static void main(String[] args) {
        TelephoneDirectory myTelephoneDirectory = new TelephoneDirectory();
        myTelephoneDirectory.add("Пупкин", "8-800-555-00-00");
        myTelephoneDirectory.add("Пупкин", "8-800-555-35-35");
        myTelephoneDirectory.get("Пупкин");
        myTelephoneDirectory.add("Васечкин", "8-999-999-99-99");
        myTelephoneDirectory.get("Васечкин");
        myTelephoneDirectory.get("Пёрышкин");
    }
}
