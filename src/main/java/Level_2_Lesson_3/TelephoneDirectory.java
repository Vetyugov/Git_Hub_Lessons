package Level_2_Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class TelephoneDirectory {
    private ArrayList<String> numbers;
    private HashMap<String, ArrayList<String>> telephoneDirectory;


    public TelephoneDirectory() {
        this.telephoneDirectory = new HashMap<>();
    }

    public void add (String secondName, String number){

        if (telephoneDirectory.containsKey(secondName)) {
            this.numbers = telephoneDirectory.get(secondName);
        } else{
            this.numbers = new ArrayList<>();
        }
        this.numbers.add(number);
        this.telephoneDirectory.put(secondName,this.numbers);
    }

    public ArrayList<String> get(String secondName){
        return this.numbers;
    }

}
