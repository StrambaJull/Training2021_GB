package level_2.lesson1;

public class Main {

    public static void main (String[] args) {
        Cat cat = new Cat("Tom", 500, 10);
        Human human = new Human("Bill", 100, 5);
        Robot robot = new Robot("Wally", 1000, 1);
        Running[] run = {cat, human, robot};
        for (Running r: run) {
            r.run();
        }
        Jumpable[] jump = {cat, human, robot};
        for(Jumpable j: jump){
            j.jump();
        }

        Participants[] participants = {cat, human, robot};
        Obstacles[] obstacles = {
                new Treadmill(200),
                new Wall(15)
        };
        for (int i = 0; i < participants.length; i++){
            for(int j = 0; j < obstacles.length; j++){
                if (obstacles[j].passTheObstacle(participants[i]) == false) {
                    break;
                }
            }
        }
    }
}
