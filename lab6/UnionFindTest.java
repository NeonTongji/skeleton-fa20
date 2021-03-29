import org.junit.Test;
import static org.junit.Assert.*;
public class UnionFindTest {

    @Test
    public void connectTest() {
        UnionFind test = new UnionFind(8);
        assertFalse(test.isConnected(3,4));
        test.connect(1,2);
        assertTrue(test.isConnected(1,2));
        test.connect(2,4);
        assertTrue(test.isConnected(1,4));
        test.connect(3,3);
        assertTrue(test.isConnected(3,3));
        try {
            test.connect(10,11);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid input");
        }

    }

}
