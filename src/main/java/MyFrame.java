import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        super("Symulator szkoły");
        //ClassTable classTable = new ClassTable();
        //add(classTable);
        JPanel panel = new MyPanel();
        //JPanel inputPanel = new LoginPanel();
        add(panel);
        //add(inputPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);










        /* setLocation(300, 100); //tworzenie przyciskow
        setSize(350,200);

        setLayout(new GridLayout(3,1,100,50));

        add(new JButton("Przycisk 1"));
        add(new JButton("Przycisk 3"));
        add(new JButton("Przycisk 2"));*/

    }
}
