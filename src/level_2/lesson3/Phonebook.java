package level_2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    Map<String, List<String>> phonebook = new HashMap<String, List<String>>();

    //добавить номер телефона в справочник
    public void add(String name, String phone){
        List<String> number = phonebook.get(name);
        if (number == null) {
            number = new ArrayList<String>();
            phonebook.put(name, number);
        }
        number.add(phone);
    }
    //искать номер телефона по фамилии
    public void get(String name){
        List<String> number = phonebook.get(name);
        System.out.println("Номера телефонов " + name + ": " + number);
    }

}
