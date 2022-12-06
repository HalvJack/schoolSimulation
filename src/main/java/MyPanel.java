import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class MyPanel extends JPanel implements ActionListener {
    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    final private JButton addClassButton;
    final private JButton addStudentButton;
    final private JButton addPointsButton;
    final private JButton getStudentButton;
    final private JButton changeConditionButton;
    final private JButton removePointsButton;
    final private JButton searchButton;
    final private JButton searchPartialButton;
    final private JButton countByConditionButton;
    final private JButton summaryButton;
    final private JButton sortByNameButton;
    final private JButton sortByPointsButton;
    final private JButton maxButton;
    final private JButton printTable;
    private JTextField className;
    private JTextField studentName;
    private JTextField studentSurname;
    private JTextField studentCondition;
    private JTextField studentYearOfBirth;
    private JTextField studentAmountOfPoints;
    public ClassContainer ourSchool;
    public ClassTable studentTable; // cos z tabela
    public ClassContainer getOurSchool() {
        return ourSchool;
    }
    public ArrayList<Class> classList = new ArrayList<Class>();
    public Class mojaKlasa;
    public void setOurSchool(ClassContainer ourSchool) {
        this.ourSchool = ourSchool;
    }

    public String getClassName() { return className.getText();}
    public String getStudentName(){
        return studentName.getText();
    }
    public String getStudentSurname(){
        return studentSurname.getText();
    }
    public String getStudentCondition(){
        return studentCondition.getText();
    }
    public String getStudentYearOfBirth(){
        return studentYearOfBirth.getText();
    }
    public String getStudentAmountOfPoints(){
        return studentAmountOfPoints.getText();
    }
    public MyPanel() {
        mojaKlasa = new Class("klasa1", 0);
        addClassButton = new JButton("Add Class");
        addStudentButton = new JButton("Add Student");
        addPointsButton = new JButton("Add Points");
        getStudentButton = new JButton("Get Student");
        changeConditionButton = new JButton("Change Condition");
        removePointsButton = new JButton("Remove Points");
        searchButton = new JButton("Search Student");
        searchPartialButton = new JButton("Search Partial");
        countByConditionButton = new JButton("Count By Condition");
        summaryButton = new JButton("Summary");
        sortByNameButton = new JButton("Sort By Names");
        sortByPointsButton = new JButton("Sort By Points");
        maxButton = new JButton("Max");
        printTable = new JButton("Print table");
        addClassButton.addActionListener(this);
        addStudentButton.addActionListener(this);
        addPointsButton.addActionListener(this);
        getStudentButton.addActionListener(this);
        changeConditionButton.addActionListener(this);
        removePointsButton.addActionListener(this);
        searchButton.addActionListener(this);
        searchPartialButton.addActionListener(this);
        countByConditionButton.addActionListener(this);
        summaryButton.addActionListener(this);
        sortByNameButton.addActionListener(this);
        sortByPointsButton.addActionListener(this);
        maxButton.addActionListener(this);
        printTable.addActionListener(this);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(14, 1));
        setPreferredSize(new Dimension(700, 500));
        buttonsPanel.add(addClassButton);
        buttonsPanel.add(addStudentButton);
        buttonsPanel.add(addPointsButton);
        buttonsPanel.add(getStudentButton);
        buttonsPanel.add(changeConditionButton);
        buttonsPanel.add(removePointsButton);
        buttonsPanel.add(searchButton);
        buttonsPanel.add(searchPartialButton);
        buttonsPanel.add(countByConditionButton);
        buttonsPanel.add(summaryButton);
        buttonsPanel.add(sortByNameButton);
        buttonsPanel.add(sortByPointsButton);
        buttonsPanel.add(maxButton);
        buttonsPanel.add(printTable);
        this.add(buttonsPanel);
        /*JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(1,1));
        ClassTable studentTable = new ClassTable();
        tablePanel.add(studentTable);
        this.add(tablePanel);*/
        createComponents();
    }
    public void createComponents(){

        JLabel nameOfOurClass = new JLabel("Class name:");
        JLabel name = new JLabel("Student name: ");
        JLabel surname = new JLabel("Student surname:");
        JLabel studentConditions = new JLabel("Student condition:"); //menu rozwijane
        JLabel yearOfBirth = new JLabel("Year of Birth:");
        JLabel amountOfPoints = new JLabel("Amount of Points:");
        className = new JTextField();
        studentName = new JTextField();
        studentSurname = new JTextField();
        studentCondition = new JTextField();
        studentYearOfBirth = new JTextField();
        studentAmountOfPoints = new JTextField();
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6,2));
        inputPanel.add(nameOfOurClass);
        inputPanel.add(className);
        inputPanel.add(name);
        inputPanel.add(studentName);
        inputPanel.add(surname);
        inputPanel.add(studentSurname);
        inputPanel.add(studentConditions);
        inputPanel.add(studentCondition);
        inputPanel.add(yearOfBirth);
        inputPanel.add(studentYearOfBirth);
        inputPanel.add(amountOfPoints);
        inputPanel.add(studentAmountOfPoints);
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        this.add(parentPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == addClassButton){
           // ourSchool.addClass(getClassName(),0);
            //String value = "lubie jablka";
            //DefaultTableModel model = new DefaultTableModel(studentTable., studentTable.columnNames);
            //model.setValueAt(value, 1, 1);
            //studentTable.firePropertyChange();
            Class aClass = new Class(className.getText(), 0);
            classList.add(aClass);

        }
        else if(source == addStudentButton){
            Student student = new Student();
            student.setName(studentName.getText());
            student.setSurname(studentSurname.getText());
            student.setStudentCondition(StudentCondition.valueOf(getStudentCondition()));
            student.setYearOfBirth(Integer.parseInt(studentYearOfBirth.getText()));
            student.setAmountOfPoints(Integer.parseInt(studentAmountOfPoints.getText()));
            //ourSchool.getClass("klasa1");
            classList.get(0).addStudent(student);
            classList.get(0).summary();
        }
        else if(source == addPointsButton){
            if(classList.get(0).search(studentSurname.getText()) != null){
                classList.get(0).addPoints(classList.get(0).search(studentSurname.getText()),
                        Integer.parseInt(studentAmountOfPoints.getText()));
            }
        }
        else if(source == getStudentButton){
            if(classList.get(0).search(studentSurname.getText()) != null) {
                classList.get(0).getStudent(classList.get(0).search(studentSurname.getText()));
            }

        }
        else if(source == changeConditionButton){
            if(classList.get(0).search(studentSurname.getText()) != null) {
                classList.get(0).changeCondition(classList.get(0).search(studentSurname.getText()),
                        StudentCondition.valueOf(getStudentCondition()));
            }
        }
        else if(source == removePointsButton){
            if(classList.get(0).search(studentSurname.getText()) != null){
                classList.get(0).addPoints(classList.get(0).search(studentSurname.getText()),
                        Integer.parseInt(studentAmountOfPoints.getText()));
            }
        }
        else if(source == searchButton){
            classList.get(0).search(studentSurname.getText());
        }
        else if(source == searchPartialButton){
            classList.get(0).searchPartial(studentSurname.getText());
        }
        else if(source == countByConditionButton){
            classList.get(0).countByCondition(StudentCondition.valueOf(getStudentCondition()));
        }
        else if(source == summaryButton){
            classList.get(0).summary();
        }
        else if(source == sortByNameButton){
            classList.get(0).sortByName();
        }
        else if(source == sortByPointsButton){
            classList.get(0).sortByPoints();
        }
        else if(source == maxButton){
            //System.out.println(classList.get(0).max());
            ((DefaultTableModel)studentTable.getModel()).removeRow(Integer.parseInt(studentAmountOfPoints.getText()));
        }
        else if(source == printTable)
        {
            Object[][] data = new Object[classList.get(0).getActualNumberOfStudents()][5];
            for (int i = 0; i < classList.get(0).getActualNumberOfStudents(); i++) {
                data[i][0] = classList.get(0).getMyList().get(i).getName();
                data[i][1] = classList.get(0).getMyList().get(i).getSurname();
                data[i][2] = classList.get(0).getMyList().get(i).getStudentCondition();
                data[i][3] = classList.get(0).getMyList().get(i).getYearOfBirth();
                data[i][4] = classList.get(0).getMyList().get(i).getAmountOfPoints();
            }
            studentTable = new ClassTable(data);
        }
    }
}












    //private BufferedImage image;

    /*public MyPanel() {
        setPreferredSize(new Dimension(700, 500));*/
        /*super();
        File imageFile = new File("java.png");
        try{
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }*/

        /*Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);*/
 /*   }*/
    /*    @Override
    protected void paintComponent(Graphics g) {*/

        //Graphics g2d = (Graphics2D) g;
        //g2d.drawImage(image, 0, 0, this);
        /*super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // prostokat
        Rectangle2D rectangle = new Rectangle2D.Double(10, 10, 380, 380);
        // kolo
        Ellipse2D circle = new Ellipse2D.Double(10, 10, 380, 380);

        g2d.draw(rectangle);
        g2d.draw(circle);*/
/*    }
}*/
