import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Dimension;

public class Frame extends JFrame {
    public Frame(){
        super("Komponenty tekstowe");

        //add(new MouseTestPanel());
        LoginListener listener = new LoginListener(this);
        JPanel loginPanel = new LoginPanel(listener);
        add(loginPanel);

        setPreferredSize(new Dimension(600,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}
