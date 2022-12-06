import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ClassTable extends JPanel {
    private boolean DEBUG = false;
    DefaultTableModel model;
    public ClassTable(Object[][] data1) {
        String[] columnNames = {"Name",
                "Surname",
                "Condition",
                "Birth of Year",
                "Amount of Points"};

        Object[][] data = data1;

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JButton button = new JButton("Set Value at row, column");
        JTextField text = new JTextField(20);
        JTextField rows = new JTextField(10);
        JTextField column = new JTextField(10);


        JPanel panel = new JPanel(new BorderLayout());
        panel.add(table, BorderLayout.NORTH);
        panel.add(text, BorderLayout.EAST);
        panel.add(rows, BorderLayout.WEST);
        panel.add(column, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String value = text.getText();
                int rowsy = Integer.parseInt(rows.getText());
                int columnsy = Integer.parseInt(column.getText());
                model.setValueAt(value, rowsy, columnsy);
            }
        });
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public Object getModel() {
        return model;
    }
}