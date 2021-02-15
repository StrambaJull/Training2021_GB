package level_2.lesson1;

public class Cat implements Running, Jumpable, Participants{
    private String name;
    private int length;
    private int height;
    public Cat (String name, int length, int height){
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
        System.out.println("Cat " + name + " run " + length + " meter");
    }

    @Override
    public void jump () {
        System.out.println("Cat " + name + " jump " + height + " meter");
    }
}
