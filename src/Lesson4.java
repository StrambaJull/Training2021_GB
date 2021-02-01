
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    /*
    1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
    2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
    3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
         Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
    4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
     */
    public static int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main (String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        };
        System.out.println("Игра закончена");
    }

    public static int checkHorizontal (char[] arr, char symb) {
        int moveCounter = 0; //счетчик по горизонтали
        for (int i = 0; i <= ((SIZE - 1) * SIZE); i = (i + SIZE)) { //отсчет строк
            for (int j = i; j < (i + SIZE); j++) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == DOTS_TO_WIN) {
                        break;
                    }
                } else {
                    moveCounter = 0;
                }
            }
            if (moveCounter == DOTS_TO_WIN) {
                break;
            }
        }
        return  moveCounter;
    }
    public static int checkVertical (char[] arr, char symb) {
        int moveCounter = 0; //счетчик по вертикали
        for (int i = 0; i < SIZE; i++) { //отсчет колонок от 0 до конца
            for (int j = i; j < arr.length; j = (j + SIZE)) {//сумма по колонкам
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == DOTS_TO_WIN) {
                        break;
                    }
                } else {
                    moveCounter = 0;
                }
            }
            if (moveCounter == DOTS_TO_WIN) {
                break;
            }
        }
        return moveCounter;
    }
    public static int checkDiagonalLeftToRightTop (char[] arr, char symb) {
        int moveCounter = 0; //счетчик по диагонали слева направо
        for (int i = 0; i < SIZE; i++) {//отсчет колонок
                for (int j = i, count = 0; count < (SIZE - count) && j < arr.length; count++, j = j + (SIZE + 1)) {
                    if (arr[j] == symb) {
                        moveCounter++;
                        if (moveCounter == DOTS_TO_WIN) {
                            break;
                        }
                    } else {
                        moveCounter = 0;
                    }
                }
            if (moveCounter == DOTS_TO_WIN) {
                break;
            }
        }
        return moveCounter;
    }
    public static int checkDiagonalLeftToRightBottom (char[] arr, char symb) {
        int moveCounter = 0; //счетчик по диагонали слева направо
        for (int i = 0; i <= ((SIZE - 1) * SIZE); i = (i + SIZE)) {//отсчет строк
            for (int j = i, count = 0; count < (SIZE - count) && j < arr.length; count++, j = j + (SIZE + 1)) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == DOTS_TO_WIN) {
                        break;
                    }
                } else {
                    moveCounter = 0;
                }
            }
            if (moveCounter == DOTS_TO_WIN) {
                break;
            }
        }
        return moveCounter;
    }
    public static int checkDiagonalRightToLeftTop (char[] arr, char symb) {
        int moveCounter = 0;
            for (int i = 0; i < (i + 1) && i < (SIZE - 1); i++) { //идем по колонкам
                for (int j = i; j < arr.length; j = j + (SIZE - 1)) {
                    if (arr[j] == symb) {
                        moveCounter++;
                        if (moveCounter == DOTS_TO_WIN) {
                            break;
                        }
                    } else {
                        moveCounter = 0;
                    }
                }
                if (moveCounter == DOTS_TO_WIN) {
                    break;
                }
            }
        return moveCounter;
    }
    public static int checkDiagonalRightToLeftBottom (char[] arr, char symb) {
        int moveCounter = 0;
        for (int i = (SIZE - 1); i < (arr.length - 1) ; i = i + SIZE) { //идем по строкам
            for (int j = i; j < arr.length; j = j + (SIZE - 1)) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == DOTS_TO_WIN) {
                        break;
                    }
                } else {
                    moveCounter = 0;
                }
            }
            if (moveCounter == DOTS_TO_WIN) {
                break;
            }
        }
        return moveCounter;
    }
    public static boolean checkWin (char symb) {
        //создадим новый массив и заполним его всеми значениями из игрового массива
        char[] arr = new char[SIZE * SIZE];
        int m = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                arr[m] = map[i][j];
                m++;
            }
        }
        if (    checkHorizontal(arr, symb) == DOTS_TO_WIN ||
                checkVertical(arr, symb) == DOTS_TO_WIN ||
                checkDiagonalLeftToRightTop(arr, symb) == DOTS_TO_WIN ||
                checkDiagonalLeftToRightBottom(arr, symb) == DOTS_TO_WIN ||
                checkDiagonalRightToLeftTop(arr, symb) == DOTS_TO_WIN ||
                checkDiagonalRightToLeftBottom(arr, symb) == DOTS_TO_WIN) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isMapFull () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn () {
        int x = 0, y = 0;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn () {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid (int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY)
        {
            return true;
        }
        return false;
    }

    public static void initMap () {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap () {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
