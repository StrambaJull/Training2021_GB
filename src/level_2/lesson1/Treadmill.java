package level_2.lesson1;

public class Treadmill implements Obstacles{
    private int length;
    public Treadmill(int length){
        this.length = length;
    }

    @Override
    public boolean passTheObstacle(Participants participants) {
        if (participants.getLength() < length) {
            System.out.println("The " + participants.getClass().getSimpleName() + " could not run");
            return false;
        } else {
            System.out.println("The " + participants.getClass().getSimpleName() + " ran successfully");
            return true;
        }
    }
}
