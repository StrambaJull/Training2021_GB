package level_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {
       // randomNumber();
        wordRandom();
    }

//1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void randomNumber () {
        int a = 0; //переменная для хранения введенного значения
        int max = 9; //верхняя граница случайного число
        int count = 0; //счетчик попыток
        int mistake = 0; //счетчик ошибок ввода данных

        Random random = new Random();

        int randomNum = random.nextInt(max+1);

        System.out.println(randomNum);

        System.out.println("Введите целое число от 0 до 9");
        Scanner sc = new Scanner(System.in);
        while (count < 3) {
            do {
                if(sc.hasNextInt()){
                    a = sc.nextInt();
                    break;
                } else {
                    sc.nextLine();
                    System.out.println("Введенное значение не число. Пожалуйста, введите число");
                }
                mistake++;
            } while (mistake < 3);

            if (mistake == 3){
                break;
            }
            if (randomNum > a) {
                System.out.println("Загаданное число больше");
            } else if (randomNum < a) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Вы угадали!");
                break;
            }
            count++;
        }
        System.out.println("Игра окончена!");
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        //очистим переменные чтобы использовать еще раз
        a = 0;
        mistake = 0;
        do {
            if (sc.hasNextInt()){
                a = sc.nextInt();
                break;
            } else {
                sc.nextLine();
                System.out.println("Введите 0 - нет, 1 - да");
            }
            mistake++;
        } while (mistake < 3);
        if (mistake != 3) {
            if (a == 1) {
                randomNumber();
            } else {
                System.out.println("FINISH!");
            }
        }
        sc.close();
    }

//2. * Создать массив из слов
//    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
//    "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
//    "pineapple", "pumpkin", "potato"}.
//    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом и сообщает,
//    правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
//    apple – загаданное
//    apricot - ответ игрока
//    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//    Для сравнения двух слов посимвольно можно пользоваться:
//    String str = "apple";
//    char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
//    Играем до тех пор, пока игрок не отгадает слово.
//    Используем только маленькие буквы.

    public static void wordRandom (){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
    "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
    "pineapple", "pumpkin", "potato"};
        //выбор слова компом
        Random randomWord = new Random();
        int randomIndex = randomWord.nextInt(words.length);
        String originalWord = words[randomIndex];
        System.out.println(words[randomIndex]);
        //Ответ игрока

        System.out.println("Выберите слово из списка" + "\n");
        System.out.println(Arrays.toString(words));
        Scanner scanner = new Scanner(System.in);
        String playerWord = scanner.nextLine();


        int victory = 0;
        do {
            char[] charArr = new char[15];
            char[] originalWordChar = originalWord.toCharArray();
            char[] playerWordChar = playerWord.toCharArray();
            StringBuilder newStringBuilder = new StringBuilder();

            //Вывод результата
            if(originalWord.equals(playerWord)){
                victory = 1;
                System.out.println("Вы угадали!");
                break;
            } else {
                for (int charW = 0; charW < charArr.length; charW++) {
                    if (charW < originalWordChar.length && charW < playerWordChar.length) {
                        if (originalWordChar[charW] == playerWordChar[charW]) {
                            charArr[charW] = playerWordChar[charW];
                            newStringBuilder.append(playerWordChar[charW]);
                        } else {
                            charArr[charW] = '.';
                            newStringBuilder.append('.');
                        }
                    } else {
                        charArr[charW] = '.';
                        newStringBuilder.append('.');
                    }
                }
                String hint = newStringBuilder.toString();
                System.out.println("Вами угаданы буквы: " + hint + "\n");
            }

            System.out.println("Выберите другое слово" + "\n");
            playerWord = scanner.nextLine();
        } while (victory == 0);








    }
}
