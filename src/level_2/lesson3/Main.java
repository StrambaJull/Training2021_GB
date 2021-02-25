package level_2.lesson3;

import java.util.Arrays;
import java.util.Hashtable;

public class Main {

    public static void main (String[] args) {
        //к первому заданию
        //Chapter1.MyArrayList();

        //ко второму заданию
       Phonebook phonebook = new Phonebook();
       phonebook.add("Киселева", "11-22");
       phonebook.add("Петрова", "22-33");
       phonebook.add("Чистов", "33-44");
       phonebook.add("Лебедев", "44-55");
       phonebook.add("Киселева", "55-66");
       phonebook.get("Киселева");
    }
}
