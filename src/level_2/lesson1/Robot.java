package level_2.lesson1;

public class Robot implements Running, Jumpable, Participants {
    private String name;
    private int length;
    private int height;
    public Robot (String name, int length, int height){
        this.name = name;
        this.length = length;
        this.height = height;
    }
    @Override
    public int getLength(){
        return length;
    }
    @Override
    public int getHeight(){
        return height;
    }
    @Override
    public void run () {
        System.out.println("Robot " + name + " run " + length + " meter");
    }
    @Override
    public void jump () {
        System.out.println("Robot " + name + " jump " + height + " meter");
    }
}
