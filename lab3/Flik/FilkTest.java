import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class FilkTest {
    private Integer a, b;
    private String expected;
    private boolean actual;

    @Test
    public void isSameNumberTest() {
        a = 1;
        b = 1;
        expected = "True";
        actual = Flik.isSameNumber(a, b);
        assertTrue(actual);


        a = 128;
        b = 128;
        actual = Flik.isSameNumber(a, b);
        assertTrue(actual);
    }

    @Test
    public void horibleSteveTest() {
        a = 128;
        b = 128;
        expected = "True";
        actual = Flik.isSameNumber(a, b);
        assertTrue(actual);


        a = 3;
        b = 3;
        actual = Flik.isSameNumber(a, b);
        assertTrue(actual);
    }

}
