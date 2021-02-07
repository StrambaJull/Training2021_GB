
import java.util.ArrayList;
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

    /*
    Краткое описание решения:
    1. игровое поле переведено в одномерный массив,
    2. для определения победителя проходим циклом по этому массиву и считаем количество фишек по направлениям: вертикаль, горизонталь,
    диагональ слева направо верхняя половина, диагональ слева направо нижняя половина, аналогично диагональ справа налево снизу и сверху
    3. для блокировки ходов противника алгоритм такой же как и при подсчете победителя. При нахождении потенциально опасного места в отдельный массив
    складываются ячейки, в которые будем ставить свою фишку и из них рандомно выбирается следующий ход.
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
                for (int j = i, count = 0; count < (SIZE - i) && j < arr.length; count++, j = j + (SIZE + 1)) {
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
        for (int i = 0, strng = 0; i <= ((SIZE - 1) * SIZE); i = (i + SIZE), strng++) {//отсчет строк
            for (int j = i, count = 0; count < (SIZE - strng) && j < arr.length; count++, j = j + (SIZE + 1)) {
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
        for (int i = (SIZE - 1), strng = 0; i < (SIZE - 1); i--, strng++) { //идем по колонкам с конца
            for (int j = i, count = 0; count < (SIZE - strng) && j < arr.length; j = j + (SIZE - 1), count++) {
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
        for (int i = (SIZE - 1), strng = 0; i < (arr.length - 1) ; i = i + SIZE, strng++) { //идем по строкам
            for (int j = i, count = 0; count < (SIZE - strng) && j < arr.length; j = j + (SIZE - 1), count++) {
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
    public static void checkHorizontalNextMove (char[] arr, char symb, ArrayList<Integer> list) {
        int moveCounter = 0; //счетчик по горизонтали
        for (int i = 0; i <= ((SIZE - 1) * SIZE); i = (i + SIZE)) { //отсчет строк
            for (int j = i; j < (i + SIZE); j++) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == (DOTS_TO_WIN - 1)) {
                        for (int nextMove = i; nextMove < (i + SIZE); nextMove++){
                            if ((nextMove + 1) > arr.length){
                                break;
                            }
                            if (arr[nextMove] == DOT_EMPTY && arr[nextMove + 1] == symb) {
                                if (list.size() == 0){
                                    list.add(nextMove);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == nextMove) {
                                            continue;
                                        } else {
                                            list.add(nextMove);
                                        }
                                    }
                                }
                            } else if (arr[nextMove] == symb && arr[nextMove+ 1] == DOT_EMPTY) {
                                if (list.size() == 0){
                                    list.add(nextMove + 1);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == (nextMove + 1)) {
                                            continue;
                                        } else {
                                            list.add(nextMove + 1);
                                        }
                                    }
                                }

                            }
                        }
                        break;
                    }
                } else {
                    moveCounter = 0;
                }
            }
            if (moveCounter == (DOTS_TO_WIN - 1)) {
                break;
            }
        }
    }
    public static void checkVerticalNextMove (char[] arr, char symb, ArrayList<Integer> list) {
        int moveCounter = 0; //счетчик по вертикали
        for (int i = 0; i < SIZE; i++) { //отсчет колонок от 0 до конца
            for (int j = i; j < arr.length; j = (j + SIZE)) {//сумма по колонкам
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == (DOTS_TO_WIN - 1)) {
                        for (int nextMove = i; nextMove < (i + SIZE); nextMove++){
                            if ((nextMove + 1) > arr.length){
                                break;
                            }
                            if (arr[nextMove] == DOT_EMPTY && arr[nextMove + 1] == symb) {
                                if (list.size() == 0){
                                    list.add(nextMove);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == nextMove) {
                                            continue;
                                        } else {
                                            list.add(nextMove);
                                        }
                                    }
                                }
                            } else if (arr[nextMove] == symb && arr[nextMove+ 1] == DOT_EMPTY) {
                                if (list.size() == 0){
                                    list.add(nextMove + 1);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == (nextMove + 1)) {
                                            continue;
                                        } else {
                                            list.add(nextMove + 1);
                                        }
                                    }
                                }

                            }
                        }
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
    }
    public static void checkDiagonalLeftToRightTopNextMove (char[] arr, char symb, ArrayList<Integer> list) {
        int moveCounter = 0; //счетчик по диагонали слева направо
        for (int i = 0; i < SIZE; i++) {//отсчет колонок
            for (int j = i, count = 0; count < (SIZE - i) && j < arr.length; count++, j = j + (SIZE + 1)) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == (DOTS_TO_WIN - 1)) {
                        for (int nextMove = i; nextMove < SIZE; nextMove++){
                            if ((nextMove + (SIZE + 1)) > arr.length){
                                break;
                            }
                            if (arr[nextMove] == DOT_EMPTY && arr[nextMove + (SIZE + 1)] == symb) {
                                if (list.size() == 0){
                                    list.add(nextMove);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == nextMove) {
                                            continue;
                                        } else {
                                            list.add(nextMove);
                                        }
                                    }
                                }
                            } else if (arr[nextMove] == symb && arr[nextMove + (SIZE + 1)] == DOT_EMPTY) {
                                if (list.size() == 0){
                                    list.add(nextMove + (SIZE + 1));
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == (nextMove + (SIZE + 1))) {
                                            continue;
                                        } else {
                                            list.add(nextMove + (SIZE + 1));
                                        }
                                    }
                                }

                            }
                        }
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
    }
    public static void checkDiagonalLeftToRightBottomNextMove (char[] arr, char symb, ArrayList<Integer> list) {
        int moveCounter = 0; //счетчик по диагонали слева направо
        for (int i = 0, strng = 0; i <= ((SIZE - 1) * SIZE); i = (i + SIZE), strng++) {//отсчет строк
            for (int j = i, count = 0; count < (SIZE - strng) && j < arr.length; count++, j = j + (SIZE + 1)) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == (DOTS_TO_WIN - 1)) {
                        for (int nextMove = i; nextMove < ((SIZE - 1) * SIZE); nextMove = nextMove + (SIZE + 1)){
                            if ((nextMove + (SIZE + 1)) > arr.length){
                                break;
                            }
                            if (arr[nextMove] == DOT_EMPTY && arr[nextMove + (SIZE + 1)] == symb) {
                                if (list.size() == 0){
                                    list.add(nextMove);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == nextMove) {
                                            continue;
                                        } else {
                                            list.add(nextMove);
                                        }
                                    }
                                }
                            } else if (arr[nextMove] == symb && arr[nextMove + (SIZE + 1)] == DOT_EMPTY) {
                                if (list.size() == 0){
                                    list.add(nextMove + (SIZE + 1));
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == (nextMove + (SIZE + 1))) {
                                            continue;
                                        } else {
                                            list.add(nextMove + (SIZE + 1));
                                        }
                                    }
                                }

                            }
                        }
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
    }
    public static void checkDiagonalRightToLeftTopNextMove (char[] arr, char symb, ArrayList<Integer> list) {
        int moveCounter = 0;
        for (int i = (SIZE - 1), strng = 0; i < (SIZE - 1); i--, strng++) { //идем по колонкам с конца
            for (int j = i, count = 0; count < (SIZE - strng) && j < arr.length; j = j + (SIZE - 1), count++) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == (DOTS_TO_WIN - 1)) {
                        for (int nextMove = i; nextMove < (i + SIZE); nextMove++){
                            if ((nextMove + (SIZE -1)) > arr.length){
                                break;
                            }
                            if (arr[nextMove] == DOT_EMPTY && arr[nextMove + (SIZE -1)] == symb) {
                                if (list.size() == 0){
                                    list.add(nextMove);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == nextMove) {
                                            continue;
                                        } else {
                                            list.add(nextMove);
                                        }
                                    }
                                }
                            } else if (arr[nextMove] == symb && arr[nextMove + (SIZE -1)] == DOT_EMPTY) {
                                if (list.size() == 0){
                                    list.add(nextMove + (SIZE -1));
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == (nextMove + (SIZE -1))) {
                                            continue;
                                        } else {
                                            list.add(nextMove + (SIZE -1));
                                        }
                                    }
                                }

                            }
                        }
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
    }
    public static void checkDiagonalRightToLeftBottomNextMove (char[] arr, char symb, ArrayList<Integer> list) {
        int moveCounter = 0;
        for (int i = (SIZE - 1), strng = 0; i < (arr.length - 1) ; i = i + SIZE, strng++) { //идем по строкам
            for (int j = i, count = 0; count < (SIZE - strng) && j < arr.length; j = j + (SIZE - 1), count++) {
                if (arr[j] == symb) {
                    moveCounter++;
                    if (moveCounter == (DOTS_TO_WIN - 1)) {
                        for (int nextMove = i; nextMove < (i + SIZE); nextMove++){
                            if ((nextMove + (SIZE - 1)) > arr.length){
                                break;
                            }
                            if (arr[nextMove] == DOT_EMPTY && arr[nextMove + (SIZE - 1)] == symb) {
                                if (list.size() == 0){
                                    list.add(nextMove);
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == nextMove) {
                                            continue;
                                        } else {
                                            list.add(nextMove);
                                        }
                                    }
                                }
                            } else if (arr[nextMove] == symb && arr[nextMove+ (SIZE - 1)] == DOT_EMPTY) {
                                if (list.size() == 0){
                                    list.add(nextMove + (SIZE - 1));
                                } else {
                                    for (int arrIndex = 0; arrIndex < list.size(); arrIndex++){
                                        if (list.get(arrIndex) == (nextMove + (SIZE -1))) {
                                            continue;
                                        } else {
                                            list.add(nextMove + (SIZE -1));
                                        }
                                    }
                                }

                            }
                        }
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
    }
    public static void aiTurn () {
        ArrayList<Integer> list = new ArrayList<>();
        //создадим новый массив и заполним его всеми значениями из игрового массива
        char[] arr = new char[SIZE * SIZE];
        int m = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                arr[m] = map[i][j];
                m++;
            }
        }
        checkHorizontalNextMove(arr, DOT_X, list);
        checkVerticalNextMove(arr, DOT_X, list);
        checkDiagonalLeftToRightTopNextMove(arr, DOT_X, list);
        checkDiagonalLeftToRightBottomNextMove(arr, DOT_X, list);
        checkDiagonalRightToLeftTopNextMove(arr, DOT_X, list);
        checkDiagonalRightToLeftBottomNextMove(arr, DOT_X, list);

        int x = 0, y = 0;
        do {
            if (list.size() > 0){
                int randMove = rand.nextInt(list.size());
                x = list.get(randMove) % SIZE;
                y = list.get(randMove) / SIZE;
            } else {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }

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
