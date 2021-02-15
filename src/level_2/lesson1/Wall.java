package level_2.lesson1;

public class Wall implements Obstacles{
    private int height;
    public Wall (int height){
        this.height = height;
    }
    @Override
    public boolean passTheObstacle(Participants participants) {
        if (participants.getHeight() < height) {
            System.out.println("The " + participants.getClass().getSimpleName() + " could not jump");
            return false;
        } else {
            System.out.println("The " + participants.getClass().getSimpleName() + " jump successfully");
            return true;
        }
    }
}
