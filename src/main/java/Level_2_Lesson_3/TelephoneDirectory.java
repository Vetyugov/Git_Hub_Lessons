package Level_2_Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {
    private ArrayList<String> numbers;
    private HashMap<String, ArrayList> telephoneDirectory;


    public TelephoneDirectory() {
        this.telephoneDirectory = new HashMap<>();
    }

    public void add (String secondName, String number){
        this.numbers = new ArrayList<>();
        if (telephoneDirectory.containsKey(secondName)) {
            this.numbers = telephoneDirectory.get(secondName);
        }
        this.numbers.add(number);
        this.telephoneDirectory.put(secondName,this.numbers);
    }

    public void get(String secondName){
        this.numbers = telephoneDirectory.get(secondName);
        System.out.println(secondName+": "+numbers);
    }

}
