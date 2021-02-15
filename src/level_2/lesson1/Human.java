package level_2.lesson1;

public class Human implements Running, Jumpable, Participants{
    private String name;
    private int length;
    private int height;
    public Human (String name, int length, int height){
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
        System.out.println("Human " + name + " run " + length + " meter");
    }
    @Override
    public void jump () {
        System.out.println("Human " + name + " jump " + height + " meter");
    }
}
