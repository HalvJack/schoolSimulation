import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private StudentCondition studentCondition;
    private int yearOfBirth;
    private double amountOfPoints;

    public Student() {
    }

    public Student(String name, String surname, StudentCondition studentCondition, int yearOfBirth, double amountOfPoints) {
        this.name = name;
        this.surname = surname;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.amountOfPoints = amountOfPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfBirth == student.yearOfBirth && Double.compare(student.amountOfPoints, amountOfPoints) == 0 && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && studentCondition == student.studentCondition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, studentCondition, yearOfBirth, amountOfPoints);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentCondition=" + studentCondition +
                ", yearOfBirth=" + yearOfBirth +
                ", amountOfPoints=" + amountOfPoints +
                '}';
    }
    @Override
    public int compareTo(Student st){
        return this.name.compareTo(st.name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentCondition getStudentCondition() {
        return studentCondition;
    }

    public void setStudentCondition(StudentCondition studentCondition) {
        this.studentCondition = studentCondition;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getAmountOfPoints() {
        return amountOfPoints;
    }

    public void setAmountOfPoints(double amountOfPoints) {
        this.amountOfPoints = amountOfPoints;
    }
}
