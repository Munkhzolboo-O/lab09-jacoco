
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class ScholarshipCalculatorTest {

    @Test
    void letterGrade_highScore_returnsA() {
        ScholarshipCalculator calculator = new ScholarshipCalculator();

        String result = calculator.letterGrade(95);

        assertEquals("A", result);
    }

    @Test
    void gpa_twoScores_returnsThreePointFive() {
        ScholarshipCalculator calculator = new ScholarshipCalculator();

        double result = calculator.gpa(new double[]{95, 85});

        assertEquals(3.5, result, 0.001);
    }

@Test
void scholarship_highGpa_returns100Percent() {
    ScholarshipCalculator calculator = new ScholarshipCalculator();

    int result = calculator.scholarship(3.9, 16, false);

    assertEquals(100, result);
}

@Test
void scholarship_goodGpa_returns70Percent() {
    ScholarshipCalculator calculator = new ScholarshipCalculator();

    int result = calculator.scholarship(3.5, 13, false);

    assertEquals(70, result);
}

@Test
void letterGrade_boundaryScores() {
    ScholarshipCalculator c = new ScholarshipCalculator();

    assertEquals("A", c.letterGrade(90));
    assertEquals("B", c.letterGrade(80));
    assertEquals("C", c.letterGrade(70));
    assertEquals("D", c.letterGrade(60));
    assertEquals("F", c.letterGrade(59));
}

@Test
void letterGrade_invalidScores() {
    ScholarshipCalculator c = new ScholarshipCalculator();

    assertThrows(IllegalArgumentException.class,
            () -> c.letterGrade(-1));

    assertThrows(IllegalArgumentException.class,
            () -> c.letterGrade(101));
}

@Test
void gpa_allGradeCategories() {
    ScholarshipCalculator c = new ScholarshipCalculator();

    assertEquals(2.0,
            c.gpa(new double[]{95, 85, 75, 65, 55}),
            0.001);
}

@Test
void gpa_invalidArrays() {
    ScholarshipCalculator c = new ScholarshipCalculator();

    assertThrows(IllegalArgumentException.class,
            () -> c.gpa(null));

    assertThrows(IllegalArgumentException.class,
            () -> c.gpa(new double[]{}));
}

@Test
void scholarship_lowerLevels() {
    ScholarshipCalculator c = new ScholarshipCalculator();

    assertEquals(50, c.scholarship(3.1, 10, false));
    assertEquals(0, c.scholarship(2.5, 10, false));
    assertEquals(0, c.scholarship(4.0, 20, true));
}

@Test
void scholarship_invalidInputs() {
    ScholarshipCalculator c = new ScholarshipCalculator();

    assertThrows(IllegalArgumentException.class,
            () -> c.scholarship(-0.1, 15, false));

    assertThrows(IllegalArgumentException.class,
            () -> c.scholarship(4.1, 15, false));

    assertThrows(IllegalArgumentException.class,
            () -> c.scholarship(3.5, -1, false));
}
@Test
void scholarship_highGpaLowCredits_returns50() {
    ScholarshipCalculator calculator = new ScholarshipCalculator();

    int result = calculator.scholarship(3.9, 10, false);

    assertEquals(50, result);
}

@Test
void gpa_zeroElements_throwsException() {
    ScholarshipCalculator c = new ScholarshipCalculator();
    assertThrows(IllegalArgumentException.class,
        () -> c.gpa(new double[]{}));
}

@Test
void gpa_oneElement_returnsFour() {
    ScholarshipCalculator c = new ScholarshipCalculator();
    assertEquals(4.0, c.gpa(new double[]{95}), 0.001);
}

@Test
void gpa_multipleElements_returnsTwoPointFive() {
    ScholarshipCalculator c = new ScholarshipCalculator();
    assertEquals(2.5, c.gpa(new double[]{95, 85, 75, 65}), 0.001);
}

}
