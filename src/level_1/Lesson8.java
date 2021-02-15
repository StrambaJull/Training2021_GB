package level_1;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Lesson8 {

    public static void main (String[] args) {
        MyWindow wind = new MyWindow();
    }

}

class MyWindow extends JFrame {
    public MyWindow (){

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 100, 800,800);
//первый вариант компоновки
//        setTitle("FIRST");
//        JButton[] buttons = new JButton[5];
//        for (int i = 0; i < buttons.length; i++){
//            buttons[i] = new JButton("#" + i);
//        }
//        setLayout(new BorderLayout());
//        add(buttons[0], BorderLayout.EAST);
//        add(buttons[1], BorderLayout.WEST);
//        add(buttons[2], BorderLayout.SOUTH);
//        add(buttons[3], BorderLayout.NORTH);
//        add(buttons[4], BorderLayout.CENTER);

// второй вариант компоновки
//        setTitle("SECOND");
//        JButton button = new JButton("Button 1 (PAGE_START)");
//        add(button, BorderLayout.PAGE_START);
//        button = new JButton("Button 2 (CENTER)");
//        button.setPreferredSize(new Dimension(150, 100));
//        add(button, BorderLayout.CENTER);
//        button = new JButton("Button 3 (LINE_STATR)");
//        add(button, BorderLayout.LINE_START);
//        button = new JButton("Button 4 (PAGE_END)");
//        add(button, BorderLayout.PAGE_END);
//        button = new JButton("5 (LINE_END");
//        add(button, BorderLayout.LINE_END);

// третий вариант компоновки
//        setTitle("THE THIRD");
//        JButton[] buttons = new JButton[10];
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); //вертикально
////        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS)); //горизонтально
//        for (int i = 0; i < buttons.length; i++){
//            buttons[i] = new JButton("#" + i);
////            buttons[i].setAlignmentX(CENTER_ALIGNMENT); //горизонтально
//            buttons[i].setAlignmentY(CENTER_ALIGNMENT); //вертикально
//            add(buttons[i]);
//        }
// четвертый вариант компоновки
//        setTitle("FOURTH");
//        JButton[] buttons = new JButton[10];
//        setLayout(new FlowLayout());
//        for (int i = 0; i < buttons.length; i++){
//            buttons[i] = new JButton("#" + i);
//            add(buttons[i]);
//        }
// пятый вариант компановки + обработка события
//        setTitle("FIFTH");
//        JButton[] buttons = new JButton[12];
//        setLayout(new GridLayout(3, 3));
//        for (int i = 0; i < buttons.length; i++){
//            buttons[i] = new JButton("#" + i);
//            buttons[i].setName("#" + i);
//            add(buttons[i]);
//            int finalI = i;
//            buttons[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed (ActionEvent e) {
//                    System.out.println("button " + buttons[finalI].getName() + " pressed");
//                }
//            });
//        }
// обработка нажатия кнопки ENTER
//        setTitle("ENTER");
//        JTextField textField = new JTextField();
//        add(textField);
//        textField.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed (ActionEvent e) {
//                System.out.println("Your message: \"" + textField.getText() + "\"");
//            }
//        });
// отслеживание кликов мыши
        setTitle("MOUSE LISTENER");
        JPanel panel = new JPanel();
        add(panel);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased (MouseEvent e) {
                System.out.println("Mouse position is: " + e.getX() + ":" + e.getY());
            }
        });

        setVisible(true);
    }

}
