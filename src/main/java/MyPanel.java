import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {
    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    private JButton addClassButton;
    private JButton addStudentButton;
    private JButton addPointsButton;
    private JButton getStudentButton;
    private JButton changeConditionButton;
    private JButton removePointsButton;
    private JButton searchButton;
    private JButton searchPartialButton;
    private JButton countByConditionButton;
    private JButton summaryButton;
    private JButton sortByNameButton;
    private JButton sortByPointsButton;
    private JButton maxButton;
    private JTextField className;
    private JTextField studentName;
    private JTextField studentSurname;
    private JTextField studentCondition;
    private JTextField studentYearOfBirth;
    private JTextField studentAmountOfPoints;
    public ClassContainer ourSchool;
    //public ClassTable studentTable;
    public ClassContainer getOurSchool() {
        return ourSchool;
    }

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
        addClassButton = new JButton("Add Class");
        addStudentButton = new JButton("Add Student");
        //addStudentButton.setPreferredSize(new Dimension(80,30));
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
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(13, 1));
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
        this.add(buttonsPanel);
        JPanel tablePanel = new JPanel();
        ClassTable studentTable = new ClassTable();
        tablePanel.add(studentTable);
        this.add(tablePanel);
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
        parentPanel.add(inputPanel, BorderLayout.CENTER);;

        this.add(parentPanel);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        Class aClass = new Class("klasa1", 0);
        if(source == addClassButton){
           // ourSchool.addClass(getClassName(),0);
           // studentTable.firePropertyChange();
        }
        else if(source == addStudentButton){
            Student student = new Student();
            student.setName(getStudentName());
            student.setSurname(getStudentSurname());
            //student.setStudentCondition(StudentCondition.valueOf(getStudentCondition()));
            student.setYearOfBirth(Integer.parseInt(getStudentYearOfBirth()));
            student.setAmountOfPoints(Integer.parseInt(getStudentAmountOfPoints()));
            //ourSchool.getClass("klasa1");
            //            aClass.addStudent(student);
            aClass.summary();

        }
        else if(source == addPointsButton){
           // Student student = new Student();
            //student.setAmountOfPoints(Integer.parseInt(studentAmountOfPoints.getText()));
        }
        else if(source == getStudentButton){

        }
        else if(source == changeConditionButton){

        }
        else if(source == removePointsButton){

        }
        else if(source == searchButton){

        }
        else if(source == searchPartialButton){

        }
        else if(source == countByConditionButton){

        }
        else if(source == summaryButton){

        }
        else if(source == sortByNameButton){

        }
        else if(source == sortByPointsButton){

        }
        else if(source == maxButton){

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
