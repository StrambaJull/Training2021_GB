public class Lesson5 {
/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Пример:
    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
    persArray[1] = new Person(...);
...
    persArray[4] = new Person(...);
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

 */
public static void main (String[] args) {

    Person[] persArray = new Person[5];
    persArray[0] = new Person("Иванов Иван", "Инженер", "ii@mail.ru", "8-111-111-11-11", 1000, 42);
    persArray[1] = new Person("Сидоров Петр", "Начальник отдела", "cp@mail.ru", "8-222-222-22-22", 1500, 50);
    persArray[2] = new Person("Петров Роман", "Контроллер", "pr@mail.ru", "8-333-333-33-33", 800, 30);
    persArray[3] = new Person("Романов Максим", "Охранник", "rm@mail.ru", "8-444-444-44-44", 500, 20);
    persArray[4] = new Person("Скворцов Михаил", "Директор", "sm@mail.ru", "8-555-555-55-55", 10000, 45);

    for (int i = 0; i < persArray.length; i++){
        if (persArray[i].age >= 40){
            persArray[i].getInfo();
            System.out.println("**************");
        }
    }
}

    static class Person {
        String fullName;
        String position;
        String email;
        String phoneNumber;
        int salary;
        int age;


        Person(String fullName, String position, String email, String phoneNumber, int salary, int age) {
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.salary = salary;
            this.age = age;
        }

        void getInfo (){
            System.out.println("ФИО: " + this.fullName);
            System.out.println("Должность: " + this.position);
            System.out.println("Адрес электронной почты: " + this.email);
            System.out.println("Телефон: " + this.phoneNumber);
            System.out.println("Зарплата: " + this.salary);
            System.out.println("Возраст: " + this.age);
        }
    }
}
