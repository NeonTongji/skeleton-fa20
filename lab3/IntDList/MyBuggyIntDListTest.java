import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyBuggyIntDListTest {
    private BuggyIntDList testList;
    @Test
    public void reverseTest(){
        testList = new BuggyIntDList(1,2,3,4,5,6,7);
        int expected = testList.size();
        testList.reverse();
        int actual = testList.size();
        assertEquals(expected, actual);
    }

}
