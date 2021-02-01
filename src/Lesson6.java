public class Lesson6 {
    /*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль.
(Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
     */

    public static void main (String[] args) {
        Animal newAnimal = new Animal();
        newAnimal.counter();
        Cat cat1 = new Cat("Маруся");
        cat1.run(400);
        cat1.counter();
        Cat cat2 = new Cat("Мурзилка");
        cat2.run(100);
        cat2.counter();
        Dog dog1 = new Dog("Дружок");
        dog1.run(300);
        dog1.swim(5);
        dog1.counter();
        Dog dog2 = new Dog("Барбос");
        dog2.run(300);
        dog2.swim(5);
        dog2.counter();
        System.out.println("Животных: " + Animal.count);
        System.out.println("Кошек: " + cat2.count);
        System.out.println("Собак: " + dog2.count);
    }

    static class Animal {
        static int count = 0;
        void run(int lenght){
            System.out.println("Животное пробежало" + lenght + "m.");
        }
        void swim(int lenght) {
            System.out.println("Животное проплыло" + lenght + "m.");
        }
        int counter1(){
            count++;
            return count;
        }
        int counter(){
            count++;
            return count;
        }
    }

    static class Cat extends Animal {
        String name;
        static int count = 0;

        Cat(String name){
           this.name = name;
        }
        @Override
        void run (int lenght) {
            if (lenght < 200){
                System.out.println(name + " пробежала " + lenght + "m.");
            } else {
                System.out.println((name + " не может так далеко бежать"));
            }
        }

        @Override
        int counter () {
            count++;
            return count;
        }
    }
    static class Dog extends Animal {
        static int count = 0;
        String name;

        Dog(String name) {
            this.name = name;
        }
        @Override
        void run(int lenght) {
            if (lenght < 500){
                System.out.println(name + " пробежал " + lenght + "m.");
            } else {
                System.out.println((name + " не может так далеко бежать"));
            }
        }
        @Override
        void swim (int lenght) {
            if (lenght < 10){
                System.out.println(name + " проплыл " + lenght + "m.");
            } else {
                System.out.println((name + " не может так далеко плыть"));
            }
        }
        @Override
        int counter () {
            count++;
            return count;
        }
    }
}
