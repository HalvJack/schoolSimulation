import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Class implements Comparator<String>{
    private String groupName;
    private ArrayList<Student> myList;
    final private int maxNumberOfStudent = 36;
    private int actualNumberOfStudents;
    private int percentageOfCapacity;

    public Class() {
    }

    public Class(String groupName, int actualNumberOfStudents) {
        this.groupName = groupName;
        this.actualNumberOfStudents = actualNumberOfStudents;
        this.myList = new ArrayList<Student>(maxNumberOfStudent);
    }
    public Class(String groupName, ArrayList<Student> myList) {
        this.groupName = groupName;
        this.myList = new ArrayList<Student>(maxNumberOfStudent);
        this.myList = myList;
        //this.percentageOfCapacity = actualNumberOfStudents/maxNumberOfStudent*100;
    }
    public Class(String groupName) {
        this.myList = new ArrayList<Student>(maxNumberOfStudent);
        this.groupName = groupName;
        //this.percentageOfCapacity = actualNumberOfStudents/maxNumberOfStudent*100;
    }
    public int getPercentageOfCapacity() {
        return percentageOfCapacity;
    }

    public void setPercentageOfCapacity(int percentageOfCapacity) {
        this.percentageOfCapacity = percentageOfCapacity;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<Student> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<Student> myList) {
        this.myList = myList;
    }

    public int getMaxNumberOfStudent() {
        return maxNumberOfStudent;
    }


    public int getActualNumberOfStudents() {
        return actualNumberOfStudents;
    }

    public void setActualNumberOfStudents(int actualNumberOfStudents) {
        this.actualNumberOfStudents = actualNumberOfStudents;
    }

public void addStudent(Student student){
        if(myList.contains(student.getName())){
        System.out.println("A student with this already exists");
        }
        if(myList.size()<maxNumberOfStudent){
        myList.add(student);
        actualNumberOfStudents++;
        changePercentageOfCapacity();
        }
        }

    private void changePercentageOfCapacity() {
        percentageOfCapacity = actualNumberOfStudents/maxNumberOfStudent*100;
    }

    public void addPoints(Student student, double points){
        student.setAmountOfPoints(student.getAmountOfPoints()+points);
        }
public void getStudent(Student student){
        if(student.getAmountOfPoints() == 0){
        myList.remove(student);
        }
        }
public void changeCondition(Student student, StudentCondition studentCondition){
        student.setStudentCondition(studentCondition);
        }
public void removePoints(Student student, double points){
        student.setAmountOfPoints(student.getAmountOfPoints()-points);
        }
public void search(String surname){
        int comparedSurname;
        for(int i = 0; i < myList.size(); i++){
            comparedSurname = compare(surname, myList.get(i).getSurname());
            if(comparedSurname == 1){
                System.out.println(myList.get(i));
                break;
            }
        }
        }
@Override
public int compare(String o1, String o2){
        //return o1.equals(o2) ? 0 : 1;
        if(o1.equals(o2)){
        return 1;
        }
        return 0;
        }
/*@Override
public int compare(double o1, double o2){
    if(o1 == o2){
        return 1;
    }
    return 0;
}*/
public void searchPartial(String nameSurname){
    for(int i = 0; i < myList.size(); i++){
       if(myList.get(i).getName().contains(nameSurname) || myList.get(i).getSurname().contains(nameSurname)){
           System.out.println(myList.get(i));
       }
    }
}
public void countByCondition(StudentCondition studentCondition){
        int counter = 0;
        for(int i = 0; i < myList.size(); i++){
        if(myList.get(i).getStudentCondition() == studentCondition){
        counter++;
        }
        }
        System.out.println(counter);
        }
public void summary(){
        for(int i = 0; i <myList.size(); i++){
        System.out.println(myList.get(i));
        }
        }
public void  sortByName(){
    Collections.sort(myList);
    System.out.println(myList);
}
public  void sortByPoints(){
    Collections.sort(myList, (Comparator.<Student> comparingDouble(Student::getAmountOfPoints).thenComparingDouble(myList2 -> myList2.getAmountOfPoints())));
//    myList.sort(new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            return Double.compare(o1.getAmountOfPoints(), o2.getAmountOfPoints());
//        }
//    });
//    myList.sort((o1, o2) -> Double.compare(o1.getAmountOfPoints(), o2.getAmountOfPoints()));
//    myList.sort(Comparator.comparingDouble(Student::getAmountOfPoints));
//    myList.sort(Comparator.comparingDouble(Student::getAmountOfPoints));
    System.out.println(myList);
}

    @Override
    public String toString() {
        return "Class{" +
                "groupName='" + groupName + '\'' +
                ", myList=" + myList +
                ", maxNumberOfStudent=" + maxNumberOfStudent +
                ", actualNumberOfStudents=" + actualNumberOfStudents +
                ", percentageOfCapacity=" + percentageOfCapacity +
                '}';
    }

    public Student max(){
    return Collections.max(myList, new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {

            if(o1.getAmountOfPoints()>o2.getAmountOfPoints())
            {
                return 1;
            }
            else {
                return 0;
            }

        }
    });


}
}
