import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {
        //changeArr();
        //simpleArr();
        //multiplicationArr();
        //multidimensionalArr();
        //minMaxArr();
        int[] arr = {1, 2, 3, 4, 5};
        int offset = 4;
        offsetArr(arr, offset);
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1.
// Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void changeArr() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void simpleArr() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void multiplicationArr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое) и
// с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void multidimensionalArr() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
            }
            arr[i][(arr[i].length - 1) - i] = 1;
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void minMaxArr() {
        int[] arr = new int[5];
        //заполнили массив случайными числами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        //вывели массив для наглядности
        System.out.println(Arrays.toString(arr));
        //перебираем элементы массива
        int k = arr[0];
        int b = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (k < arr[j]) {
                k = arr[j];
            }
            if (b > arr[j]) {
                b = arr[j];
            }
        }
        System.out.println("Наибольшее значение: " + k);
        System.out.println("Наименьшее значение: " + b);
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.
    public static boolean checkBalance(int[] arr) {
        int summLeft = 0;
        int summRight = 0;
        boolean rez = false;
        //общий цикл
        //цикл для сбора суммы слева
        for (int m = 0; m < arr.length; m++) {
            summLeft = summLeft + arr[m];
            //цикл для сбора суммы справа
            for (int n = m + 1; n < arr.length; n++) {
                summRight = summRight + arr[n];
            }
            if (summLeft == summRight) {
                rez = true;
                break;
            } else {
                rez = false;
            }
            summRight = 0;
        }
        return rez;
    }

    //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
// При каком n в какую сторону сдвиг можете выбирать сами.
    public static void offsetArr(int[] arr, int offset) {
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Смещение: " + offset);
        int j = arr[0];
        int n = 0;
        for (int i = 0; i < arr.length; i++){
            n = n + offset;
            if (offset > 0) {
                if (n == arr.length || n > arr.length) {
                    n = n - arr.length;
                }
            }
            else {
                if (n < 0){
                    n = arr.length + n;
                } else if (n > arr.length){
                    n = n - arr.length;
                }
            }
                int m = arr[n];
                arr[n] = j;
                j = m;
            }
        System.out.println("Преобразованный массив: " + Arrays.toString(arr));
    }
}
