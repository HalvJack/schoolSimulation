import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import  java.awt.EventQueue;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
    EventQueue.invokeLater((new Runnable() {
        @Override
        public void run() {
            /*Connection conn = null;
            Statement stmt = null;
            try{
                //Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection("jdbc:h2:~/test", "sa","");
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            catch(Exception e){
                e.printStackTrace();
            }*/
            new MyFrame();
            ClassContainer ourSchool = new ClassContainer();
            ourSchool.addClass("klasa1", 5);
            ourSchool.addClass("klasa2", 0);
            ourSchool.addClass("klasa3", 2);
            ourSchool.addClass("klasa4", 0);
            ourSchool.summary();
            List<Class> empty = ourSchool.findEmpty();
            for (Class aClass : empty) {
                System.out.println(aClass);
            }
            Student firstStudent = new Student("Jakub", "Halucha", StudentCondition.ABSENT, 2000, 10);
            Student secondStudent = new Student("Olek", "Turocha", StudentCondition.SICK, 1000, 2);
            Student thirdStudent = new Student("Adam", "Wasylewicz", StudentCondition.PRESENT, 3000, 34);
            Class klasa1 = new Class("mojaKlasa", 0);
            klasa1.addStudent(firstStudent);
            klasa1.addStudent(secondStudent);
            klasa1.addStudent(thirdStudent);
            klasa1.addStudent(secondStudent);
            klasa1.addStudent(firstStudent);

            klasa1.sortByPoints();
            firstStudent.setName("Patryk");
            klasa1.summary();


        }
    }));
    }
}

