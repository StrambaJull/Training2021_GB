package level_2.lesson2;

public class MyArrayDataException extends NumberFormatException {
    String str;
    public MyArrayDataException(String str) {
        this.str = str;
        System.out.println(str);
    }

}

