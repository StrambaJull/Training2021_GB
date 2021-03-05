package level_2.lesson5;

import sun.lwawt.macosx.CSystemTray;

import java.util.Arrays;

public class MyThread {

    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE/2;

    //создание и заполнение начального массива
    private static float[] prepareArray () {
        float[] arr = new float[SIZE];
        Arrays.fill(arr,1);
        return arr;
    }
    private static long method1(){
        float[] arr = prepareArray(); //создали массив
        long time = System.currentTimeMillis(); //засекли время
        for (int i = 0; i < arr.length; i++) { //произвели требуемые операции
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis() - time; //вывели время
    }
    private static long method2() throws InterruptedException {
        float[] arr = prepareArray(); //создали исходный массив
        long time = System.currentTimeMillis(); //засекли время
        float[] arr1 = new float[HALF]; //создали первый массив, в него положим первую половину исходного
        System.arraycopy(arr, 0, arr1, 0, HALF); //скопировали с исходного, начиная с первой позиции в arr1 начиная с позиции 0 половину
        float[] arr2 = new float[HALF]; //создали второй массив, в него положим вторую половину исходного
        System.arraycopy(arr, HALF, arr2,0, HALF); //скопировали с исходного, начиная с позиции половины массива в arr2 начиная с позиции 0 половину
        //сформировали первый поток по первому массиву
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        //сформировали второй поток по второму массиву
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run () {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        thread1.start(); //запустили первый поток
        thread1.join(); //главный поток не может завершиться пока не завершится этот поток
        thread2.start(); //запустили второй поток
        thread2.join(); //главный поток не может завершиться пока не завершится этот поток

        System.arraycopy(arr1, 0, arr, 0, HALF); //положили все из arr1 в основной массив начиная с 0 позиции
        System.arraycopy(arr2, 0, arr, HALF, HALF); //положили все из arr2 в основной массив начиная с позиции половины

        return System.currentTimeMillis() - time; //посчитали время
    }

    public static void main (String[] args) {
        System.out.println("Method1: " + method1());
        try {
            System.out.println("Method2: " + method2());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
