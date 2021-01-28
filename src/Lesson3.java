import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {
        randomNumber();
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

}
