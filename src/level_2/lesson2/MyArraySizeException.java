package level_2.lesson2;

import com.sun.org.apache.xerces.internal.impl.XMLEntityScanner;

public class MyArraySizeException extends IndexOutOfBoundsException{
    public int length;
    String message;
    MyArraySizeException (int length, String message){
        this.length = length;
        System.out.println(message + length);
    }
}
