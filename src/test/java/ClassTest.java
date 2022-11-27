import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassTest {

    @Test
    void sortByPoints_shouldSortByPoints() {
        // given
        Student firstStudent = new Student("Jakub", "Halucha", StudentCondition.ABSENT, 2000, 10);
        Student secondStudent = new Student("Olek", "Turocha", StudentCondition.SICK, 1000, 2);
        Student thirdStudent = new Student("Adam", "Wasylewicz", StudentCondition.PRESENT, 3000, 34);
        Class klasa1 = new Class("mojaKlasa", 0);
        klasa1.addStudent(firstStudent);
        klasa1.addStudent(firstStudent);
        klasa1.addStudent(firstStudent);
        klasa1.addStudent(thirdStudent);

        // when
        klasa1.sortByPoints();

        // then

        Assertions.assertEquals(4, klasa1.getMyList().size());
        Assertions.assertEquals(new Student("Jakub", "Halucha", StudentCondition.ABSENT, 2000, 10), klasa1.getMyList().get(0));
        Assertions.assertEquals(new Student("Jakub", "Halucha", StudentCondition.ABSENT, 2000, 10), klasa1.getMyList().get(1));
        Assertions.assertEquals(new Student("Jakub", "Halucha", StudentCondition.ABSENT, 2000, 10), klasa1.getMyList().get(2));
        Assertions.assertEquals(new Student("Adam", "Wasylewicz", StudentCondition.PRESENT, 3000, 34), klasa1.getMyList().get(3));
    }
}