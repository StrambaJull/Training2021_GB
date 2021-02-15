package level_1;

public class Lesson1 {
    //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
    byte b = 33;
    int i = 100;
    long l = 12L;
    short s = 3;
    char c = 'h';

    float f = 3.9f;
    double d = 4.4d;

    boolean bool = true;

    public static void main(String[] args) {
        int i = 0;
        int y = 9;
        System.out.println("4.");
        System.out.println(compare(i, y));

        System.out.println("5.");
        printSmth(i);

        System.out.println("6.");
        System.out.println(smthMetod(i));

        System.out.println("7.");
        String s = "Юлия";
        printName(s);

        System.out.println("8.");
        leapYear(2021);
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float.
    public static float evaluateExpression (float a, float b, float c, float d){
        return (a * (b + (c / d)));
    }
    //4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false.
    public static boolean compare (int i, int y){
        return (i + y) >= 10 && (i + y) <= 20;
    }
    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    // положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void printSmth (int i) {
        if (i < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }
    //6. Написать метод, которому в качестве параметра передается целое число.
    // Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    public static boolean smthMetod (int i) {
        return i < 0;
    }
    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    // Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    public static void printName(String s){
        System.out.println("Привет, " + s + "!");
    }
    //8. Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void leapYear (int g) {
        if ((g % 400) == 0) {
            System.out.println("Год високосный");
        } else if ((g % 4) == 0 && (g % 100) != 0) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }

}
