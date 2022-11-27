import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClassTable extends JPanel {
    private boolean DEBUG = false;
    String[] columnNames = {"Name",
            "Surname",
            "Condition",
            "Birth of Year",
            "Amount of Points"};

    Object[][] data = {
            {"Kathy", "Smith",
                    "Snowboarding", 5, false},
            {"John", "Doe",
                    "Rowing", 3, true},
            {"Sue", "Black",
                    "Knitting", 2, false},
            {"Jane", "White",
                    "Speed reading", 20, true},
            {"Joe", "Brown",
                    "Pool", 10, false}
    };
    DefaultTableModel model = new DefaultTableModel(data, columnNames);
    JTable table = new JTable(model);
    JButton button = new JButton("Set Value at 1, 1");
    JTextField text = new JTextField(20);
    public ClassTable() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(table, BorderLayout.NORTH);
        panel.add(text, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String value = text.getText();
                model.setValueAt(value, 1, 1);
            }
        });
        /*JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);*/

    }

}