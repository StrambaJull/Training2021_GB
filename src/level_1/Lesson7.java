package level_1;

public class Lesson7 {
/*
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
    public static class MainClass {
        public static void main(String[] args) {
            Cat[] cats = new Cat[4];
            cats[0] = new Cat("Tom", 5, false);
            cats[1] = new Cat("Bill", 4, false);
            cats[2] = new Cat("Jack", 6, false);
            cats[3] = new Cat("Barsik", 5, false);
            Plate plate = new Plate(10);
            plate.info();
            for (int i = 0; i < cats.length; i++){
                if (cats[i].appetite > plate.food){
                    plate.addFood(10);
                    System.out.println("Еды не хватило. Добавлено еще: " + plate.food);
                    cats[i].eat(plate);
                } else {
                    cats[i].eat(plate);
                }
                System.out.println(cats[i].name + " сыт: " + cats[i].satiety);
            }
            System.out.println("Осталось еды: " + plate.food);
        }
    }
    public static class Plate {
        private static int food;

        public Plate(int food) {
            this.food = food;
        }
        public void decreaseFood(int n) {
            if (n <= food){
                food -= n;
            }
        }
        public void addFood(int food){
            this.food = food;
        }
        public void info() {
            System.out.println("plate: " + food);
        }
    }
    public static class Cat {
        private String name;
        private int appetite;
        private boolean satiety;

        public Cat(String name, int appetite, boolean satiety) {
            this.name = name;
            this.appetite = appetite;
            this.satiety = satiety;
        }
        public void eat(Plate p) {
            if (appetite <= p.food) {
                p.decreaseFood(appetite);
                satiety = true;
            } else {
                satiety = false;
            }

        }
    }


}
